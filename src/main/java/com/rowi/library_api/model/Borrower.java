package com.rowi.library_api.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    private Boolean isBorrowed;

}
