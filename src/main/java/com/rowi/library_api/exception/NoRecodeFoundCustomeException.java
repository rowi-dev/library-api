package com.rowi.library_api.exception;

public class NoRecodeFoundCustomeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoRecodeFoundCustomeException() {
        super();
    }

    public NoRecodeFoundCustomeException(String message) {
        super(message);
    }

    public NoRecodeFoundCustomeException(String message, Throwable e) {
        super(message, e);
    }

}
