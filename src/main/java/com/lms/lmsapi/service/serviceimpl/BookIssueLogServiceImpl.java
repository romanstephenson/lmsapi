package com.lms.lmsapi.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsapi.entity.BookIssueLog;
import com.lms.lmsapi.repository.BookIssueLogRepository;
import com.lms.lmsapi.service.BookIssueLogService;

import java.util.List;
import java.util.Optional;

@Service
public class BookIssueLogServiceImpl implements BookIssueLogService
{
    @Autowired
    private BookIssueLogRepository bookIssueLogRepository;

    @Override
    public BookIssueLog getBookIssuedById(Long id)
    {
        Optional<BookIssueLog> optionalBookIssueLog = bookIssueLogRepository.findById(id);

        return optionalBookIssueLog.get();
    }
    
    @Override
    public BookIssueLog issueBook(BookIssueLog issuedBook)
    {
        return bookIssueLogRepository.save(issuedBook);
    }

    @Override
    public BookIssueLog updateIssuedBook(BookIssueLog bookissuelog)
    {

        BookIssueLog existingBookIssueLog = bookIssueLogRepository.findById(bookissuelog.getBookissueid().longValue()).get();

        existingBookIssueLog.setBookid(bookissuelog.getBookid());
        existingBookIssueLog.setBookissueid(bookissuelog.getBookissueid());
        existingBookIssueLog.setIssueDt(bookissuelog.getIssueDt());
        existingBookIssueLog.setIssuedby(bookissuelog.getIssuedby());
        existingBookIssueLog.setIssuedto(bookissuelog.getIssuedto());
        existingBookIssueLog.setModifiedDt(bookissuelog.getModifiedDt());
        existingBookIssueLog.setReturnDt(bookissuelog.getReturnDt());

        BookIssueLog updatedBookIssueLog = bookIssueLogRepository.save(existingBookIssueLog);

        return updatedBookIssueLog;
    }

    @Override
    public List<BookIssueLog> getBooksIssuedByUserId(Long id)
    {
        return (List<BookIssueLog>) bookIssueLogRepository.findAll();
    }
    
}
