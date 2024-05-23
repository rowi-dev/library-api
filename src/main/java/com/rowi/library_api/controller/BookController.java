package com.rowi.library_api.controller;


import com.rowi.library_api.model.Book;
import com.rowi.library_api.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.rowi.library_api.util.Constant.ApiUri.BOOK;
import static com.rowi.library_api.util.Constant.ApiUri.V1_BASE_URL;

@RestController
@RequestMapping(V1_BASE_URL + BOOK)
@Log4j2
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @GetMapping
    public List<Book> getBooks() {
        log.info("Get Books : STARTED");
        return bookService.getAllBooks();
    }
}
