package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.BookIssueLog;

public interface BookIssueLogService 
{
    //List<User> getBooksIssued();
    List<BookIssueLog> getBooksIssuedByUserId(Long id);
    BookIssueLog getBookIssuedById(Long id);
    BookIssueLog issueBook(BookIssueLog issuedBook);
    BookIssueLog updateIssuedBook(BookIssueLog bookissuelogid);
}
