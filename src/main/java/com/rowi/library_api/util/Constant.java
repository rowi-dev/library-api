package com.rowi.library_api.util;

public interface Constant {
    interface ApiUri {

        String V1_BASE_URL = "/api/v1";
        String BOOK = "/book";
        String BORROWER = "/borrower";
        String BORROW_BOOK = "/borrow";
        String RETURN_BOOK = "/return";
        String BY_ID = "/{id}";
    }

    interface ErrorMsg{
        String NO_RECODE_FOUND = "No recodes found";
        String BOOK_NO_RECODE_FOUND = "No book recode found for ID: {}";
        String BOOK_ALREADY_BORROWED = "Book already borrowed with Book Id: {}";
        String BORROWER_NO_RECODE_FOUND = "No borrower recode found for ID: {}";
        String NO_BOOKRECODE_FOUND_FOR_BORROWER = "No Borrowed book recorde found for borrowerId: {}";
        String INVALID_BOOK_ID = "Invalid borrowed book for borrowerId: {}";
    }

    interface ResponseCode {
        String SUCCESS = "200";
    }
}
