package com.rowi.library_api.controller;


import com.rowi.library_api.dto.BorrowerDto;
import com.rowi.library_api.dto.CommonResponse;
import com.rowi.library_api.model.Book;
import com.rowi.library_api.model.Borrower;
import com.rowi.library_api.service.BookService;
import com.rowi.library_api.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import static com.rowi.library_api.util.Constant.ApiUri.*;

@RestController
@RequestMapping(V1_BASE_URL)
@Log4j2
@RequiredArgsConstructor
public class LibraryController {

    private final BookService bookService;

    @PostMapping(BOOK + BY_ID + BORROW_BOOK)
    public CommonResponse<Book> borrowBook(@PathVariable Long id, @RequestParam("borrower") Long borrower){
        log.info("Borrow Book User: {}, Book: {} : START", borrower, id);
        Book bookResponse = bookService.borrowBook(id, borrower);
        log.info("Borrow book compleated");
        log.debug("Borrowed book {}", bookResponse);
        return CommonResponse.ok(bookResponse);
    }

    @PostMapping(BOOK + BY_ID + RETURN_BOOK)
    public CommonResponse<Book> returnBook(@PathVariable Long id, @RequestParam("borrower") Long borrower){
        log.info("Return Book User: {}, Book: {} : START", borrower, id);
        Book bookResponse = bookService.returnBook(id, borrower);
        log.info("Return book compleated");
        log.debug("Return book {}", bookResponse);
        return CommonResponse.ok(bookResponse);
    }
}
