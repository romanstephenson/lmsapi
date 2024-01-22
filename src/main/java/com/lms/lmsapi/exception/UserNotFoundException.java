package com.lms.lmsapi.exception;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String exception) {
        super(exception);
    }

    public UserNotFoundException(Long id) {
        super("User not found with ID: " + id);
    }
}
 