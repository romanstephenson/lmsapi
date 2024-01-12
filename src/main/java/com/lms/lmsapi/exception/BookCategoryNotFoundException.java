package com.lms.lmsapi.exception;

public class BookCategoryNotFoundException extends RuntimeException {
    public BookCategoryNotFoundException(String exception)
    {
        super(exception);
    }
}

