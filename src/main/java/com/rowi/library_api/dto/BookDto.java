package com.rowi.library_api.dto;

import lombok.Data;

@Data
public class BookDto {
    private String isbn;
    private String title;
    private String author;
    private Boolean isBorrow;
}
