package com.rowi.library_api.exception;

public class CustomeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomeException() {
        super();
    }

    public CustomeException(String message) {
        super(message);
    }

    public CustomeException(String message, Throwable e) {
        super(message, e);
    }

}
