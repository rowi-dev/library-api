package com.rowi.library_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Borrower {
    @Id
    private Long id;
    private String name;
    private String email;
    private Boolean isBorrowed;

}
