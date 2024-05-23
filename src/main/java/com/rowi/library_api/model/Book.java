package com.rowi.library_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private Boolean isBorrow;
}
