package com.lms.lmsapi.exception;

public class StaffException extends RuntimeException
{
    public StaffException(String exception)
    {
        super(exception);
    }

    public StaffException(Long id)
    {
        super("Staff not found with ID: " + id);
    }
}
