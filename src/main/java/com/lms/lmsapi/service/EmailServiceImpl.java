package com.lms.lmsapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsapi.entity.Email;
import com.lms.lmsapi.exception.EmailNotFoundException;
import com.lms.lmsapi.repository.EmailRepository;


import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService 
{

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public List<Email> getEmails()
    {
        return(List<Email>) emailRepository.findAll();
    }

    @Override
    public Email getEmailByUserId(int userId)
    {
        Optional<Email> optionalEmail = emailRepository.findById(userId);

        if(optionalEmail.isPresent())
        {
            return optionalEmail.get();
        }
        else
        {
            throw new EmailNotFoundException("Email address not found.");
        }
    }

    @Override
    public Email createUserEmail(Email email)
    {
        if (email != null) 
        {
            return emailRepository.save(email);
        } 
        else {
            throw new EmailNotFoundException("Email not found.");
        }
    }

    @Override
    public Email updateEmailByUserId(Email email)
    {
        Email existingEmailForUser = emailRepository.findById(email.getId()).get();

        existingEmailForUser.setEmailAddress(email.getEmailAddress());
        existingEmailForUser.setIsPrimary(email.getIsPrimary());
        existingEmailForUser.setUserId(email.getUserId());
        existingEmailForUser.setModifiedDt(email.getModifiedDt());

        Email updatedEmail = emailRepository.save(existingEmailForUser);

        return updatedEmail;

    }

    @Override
    public void deleteUserEmail(int id)
    {
        emailRepository.deleteById(id);
    }
}
