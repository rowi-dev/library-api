package com.rowi.library_api.service;


import com.rowi.library_api.dto.BookDto;
import com.rowi.library_api.exception.CustomeException;
import com.rowi.library_api.exception.NoRecodeFoundCustomeException;
import com.rowi.library_api.map.BookMapper;
import com.rowi.library_api.model.Book;
import com.rowi.library_api.model.Borrower;
import com.rowi.library_api.repository.BookRepository;
import com.rowi.library_api.repository.BorrowerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.rowi.library_api.util.Constant.ErrorMsg.*;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BorrowerRepository borrowerRepository;

    public List<Book> getAllBooks() {
        log.info("Get All Books : START");
        List<Book> books = bookRepository.findAll();
        if (CollectionUtils.isEmpty(books)) {
            log.info("No books found");
            throw new NoRecodeFoundCustomeException(NO_RECODE_FOUND);
        }
        log.info("{} Books found", books.size());
        return books;
    }

    public Book createBook(BookDto bookDto) {
        log.info("Create Book: START");
        // TODO: Validations need to done
        Book book = BookMapper.toEntity(bookDto);
        book = bookRepository.save(book);
        return book;
    }

    public Book borrowBook(Long bookId, Long borrowerId) {
        log.info("Borrow book: START");
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        Book book;
        if(optionalBook.isEmpty()){
            log.warn("No Book recorde found for BookId: {}", bookId);
            throw new NoRecodeFoundCustomeException(String.format(BOOK_NO_RECODE_FOUND, bookId));
        }  else {
             book = optionalBook.get();
             if(book.getIsBorrow()) {
                 log.warn(" Book already borrowed with BookId: {}", bookId);
                 throw new CustomeException(String.format(BOOK_ALREADY_BORROWED, bookId));
             }
        }

        Optional<Borrower> optionalBorrower = borrowerRepository.findById(borrowerId);
        if(optionalBorrower.isEmpty()){
            log.warn("No Borrower recorde found for borrowerId: {}", borrowerId);
            throw new NoRecodeFoundCustomeException(String.format(BORROWER_NO_RECODE_FOUND, borrowerId));
        }

        Borrower borrower = optionalBorrower.get();
        book.setIsBorrow(Boolean.TRUE);
        borrower.setBook(book);
        borrower.setIsBorrowed(Boolean.TRUE);

        book = bookRepository.save(book);
        borrowerRepository.save(borrower);
        return book;
    }

    public Book returnBook(Long bookId, Long borrowerId) {
        log.info("Borrow book: START");
        Book book;
        Optional<Borrower> optionalBorrower = borrowerRepository.findById(borrowerId);
        if(optionalBorrower.isEmpty()){
            log.warn("No Borrower recorde found for borrowerId: {}", borrowerId);
            throw new NoRecodeFoundCustomeException(String.format(BORROWER_NO_RECODE_FOUND, borrowerId));
        } else {
            Borrower borrower = optionalBorrower.get();
            if(borrower.getBook() == null) {
                log.warn("No Borrowed book recorde found for borrowerId: {}", borrowerId);
                throw new NoRecodeFoundCustomeException(String.format(NO_BOOKRECODE_FOUND_FOR_BORROWER, borrowerId));
            }
             book = borrower.getBook();
            if(book.getBorrower() == null || !Objects.equals(book.getBorrower().getId(), bookId)) {
                log.warn("Invalid borrowed book for borrowerId: {}", borrowerId);
                throw new NoRecodeFoundCustomeException(String.format(INVALID_BOOK_ID, borrowerId));
            }
        }

        Borrower borrower = optionalBorrower.get();
        book.setIsBorrow(Boolean.FALSE);
        book.setBorrower(null);
        borrower.setIsBorrowed(Boolean.FALSE);
        borrower.setBook(null);

        book = bookRepository.save(book);
        return book;
    }
}
