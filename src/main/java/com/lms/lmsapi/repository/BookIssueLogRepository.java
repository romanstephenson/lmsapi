package com.lms.lmsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.BookIssueLog;

@Repository
public interface BookIssueLogRepository extends JpaRepository<BookIssueLog, Long>
{
    
}
