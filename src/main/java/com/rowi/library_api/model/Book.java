package com.rowi.library_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private Boolean isBorrow;

    @OneToOne(mappedBy = "book")
    private Borrower borrower;
}
