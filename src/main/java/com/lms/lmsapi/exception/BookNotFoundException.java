package com.lms.lmsapi.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String exception)
    {
        super(exception);
    }
}

