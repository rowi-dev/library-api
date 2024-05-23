package com.rowi.library_api.service;

import com.rowi.library_api.dto.BookDto;
import com.rowi.library_api.dto.BorrowerDto;
import com.rowi.library_api.map.BookMapper;
import com.rowi.library_api.map.BorrowerMapper;
import com.rowi.library_api.model.Book;
import com.rowi.library_api.model.Borrower;
import com.rowi.library_api.repository.BorrowerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    public Borrower createBorrower(BorrowerDto borrowerDto) {
        log.info("Create borrower: START");
        // TODO: Validations need to done
        Borrower borrower = BorrowerMapper.toEntity(borrowerDto);
        borrower = borrowerRepository.save(borrower);
        return borrower;
    }
}
