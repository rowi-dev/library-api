package com.rowi.library_api.map;

import com.rowi.library_api.dto.BookDto;
import com.rowi.library_api.model.Book;

public class BookMapper {

    public static BookDto toDTO(Book Book) {
        BookDto dto = new BookDto();
        dto.setIsbn(Book.getIsbn());
        dto.setTitle(Book.getTitle());
        dto.setAuthor(Book.getAuthor());
        dto.setIsBorrow(Book.getIsBorrow());
        return dto;
    }

    public static Book toEntity(BookDto dto) {
        Book Book = new Book();
//        Book.setId(dto.getId()); Commented out this to keep create flow
        Book.setAuthor(dto.getAuthor());
        Book.setIsbn(dto.getIsbn());
        Book.setTitle(dto.getTitle());
        Book.setIsBorrow(Boolean.FALSE);
        return Book;
    }
}
