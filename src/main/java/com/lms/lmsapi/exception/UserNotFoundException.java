package com.lms.lmsapi.exception;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String exception) {
        super(exception);
    }
}
