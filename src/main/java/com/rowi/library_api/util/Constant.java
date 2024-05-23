package com.rowi.library_api.util;

public interface Constant {
    interface ApiUri {

        String V1_BASE_URL = "/api/v1";
        String BOOK = "/book";
        String BORROWER = "/borrower";
        String BY_ID = "/{id}";
    }

    interface ErrorMsg{
        String NO_RECODE_FOUND = "No recode found";
    }
}
