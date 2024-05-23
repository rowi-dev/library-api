package com.rowi.library_api.controller;


import com.rowi.library_api.dto.BookDto;
import com.rowi.library_api.dto.BorrowerDto;
import com.rowi.library_api.dto.CommonResponse;
import com.rowi.library_api.model.Borrower;
import com.rowi.library_api.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.rowi.library_api.util.Constant.ApiUri.*;

@RestController
@RequestMapping(V1_BASE_URL + BORROWER)
@Log4j2
@RequiredArgsConstructor
public class BorrowerController {

    private final BorrowerService borrowerService;

    @PostMapping
    public ResponseEntity<CommonResponse<Borrower>> createBook(@RequestBody BorrowerDto borrower){
        log.info("Create Borrower : START");
        log.debug("Create Borrower request with {}", borrower);
        Borrower borrowerResponse = borrowerService.createBorrower(borrower);
        log.info("Borrower Created");
        log.debug("Borrower Created {}", borrowerResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.ok(borrowerResponse));
    }
}
