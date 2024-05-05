package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.service.*;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/lmsapi")
public class BookIssueController 
{
    private BookIssueLogService bookIssueLogService;

    @Autowired
    public void BookIssueLogService(BookIssueLogService bookIssueLogService){ this.bookIssueLogService = bookIssueLogService; }

    @PostMapping(value = "/v1/issuebook")
    public ResponseEntity<BookIssueLog> issueBook(@RequestBody BookIssueLog bookIssueLog)
    {
        if(bookIssueLog != null)
        {
            BookIssueLog savedBookIssueLog = bookIssueLogService.issueBook(bookIssueLog);

            return new ResponseEntity<>(savedBookIssueLog, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
