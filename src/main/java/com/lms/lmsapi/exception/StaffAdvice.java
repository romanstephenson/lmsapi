package com.lms.lmsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StaffAdvice 
{
    @ResponseBody
    @ExceptionHandler(StaffException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String staffExceptionHandler(StaffException ex)
    {
        return ex.getMessage();
    }
}
