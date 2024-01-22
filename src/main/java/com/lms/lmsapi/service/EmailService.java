package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.Email;

public interface EmailService {

    List<Email> getEmails();
    Email getEmailByUserId(Long id);
    Email createUserEmail(Email email);
    Email updateEmailByUserId(Email email);
    void deleteUserEmail(Long userId);    
}