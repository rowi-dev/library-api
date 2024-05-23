package com.rowi.library_api.map;

import com.rowi.library_api.dto.BorrowerDto;
import com.rowi.library_api.model.Borrower;

public class BorrowerMapper {

    public static BorrowerDto toDTO(Borrower borrower) {
        BorrowerDto dto = new BorrowerDto();
        dto.setName(borrower.getName());
        dto.setEmail(borrower.getEmail());
        return dto;
    }

    public static Borrower toEntity(BorrowerDto dto) {
        Borrower borrower = new Borrower();
//        Book.setId(dto.getId()); Commented out this to keep create flow
        borrower.setName(dto.getName());
        borrower.setEmail(dto.getEmail());
        borrower.setIsBorrowed(Boolean.FALSE);
        return borrower;
    }
}
