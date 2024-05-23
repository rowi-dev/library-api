package com.rowi.library_api.controller;


import com.rowi.library_api.dto.BookDto;
import com.rowi.library_api.dto.CommonResponse;
import com.rowi.library_api.model.Book;
import com.rowi.library_api.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.rowi.library_api.util.Constant.ApiUri.BOOK;
import static com.rowi.library_api.util.Constant.ApiUri.V1_BASE_URL;
import static com.rowi.library_api.util.Constant.ResponseCode.SUCCESS;

@RestController
@RequestMapping(V1_BASE_URL + BOOK)
@Log4j2
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @GetMapping
    public CommonResponse<List<Book>> getBooks() {
        log.info("Get Books : START");
        List books = bookService.getAllBooks();
        return CommonResponse.okList(books, SUCCESS);
    }

    @PostMapping
    public ResponseEntity<CommonResponse<Book>> createBook(@RequestBody BookDto book){
        log.info("Create Book : START");
        log.debug("Create Book request with {}", book);
        Book bookResponse = bookService.createBook(book);
        log.info("Book Created");
        log.debug("Book Created {}", bookResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.ok(bookResponse));
    }
}
