package com.rowi.library_api.service;


import com.rowi.library_api.exception.NoRecodeFoundCustomeException;
import com.rowi.library_api.model.Book;
import com.rowi.library_api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.rowi.library_api.util.Constant.ErrorMsg.NO_RECODE_FOUND;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    public List<Book> getAllBooks(){
        log.info("Get All Books : START");
        List<Book> books = bookRepository.findAll();
        if(CollectionUtils.isEmpty(books)) {
            log.info("No books found");
            throw new NoRecodeFoundCustomeException(NO_RECODE_FOUND);
        }
        log.info("{} Books found", books.size());
        return books;
    }
}
