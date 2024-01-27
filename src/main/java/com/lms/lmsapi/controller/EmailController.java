package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.service.*;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/lmsapi")
public class EmailController 
{
    private EmailService emailService;
    
    @Autowired
    public void setEmailService(EmailService EmailService){ this.emailService = EmailService; }
    
    
    /** Creates an email address for a user
     * @param email
     * @return returns created email object
     */
    @PostMapping(value = "/v1/createuseremail")
    public ResponseEntity<Email> createEmail(@RequestBody Email email) 
    {
        System.out.println(email);
        
        if(email != null)
        {
            Email savedEmail = emailService.createUserEmail(email);

            return new ResponseEntity<>(savedEmail, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }
    
    /** updates an existing email address for a user
     * @param email
     * @return returns updated email object
     */
    @PutMapping(value = "/v1/updateuseremail/{id}")
    public ResponseEntity<Email> updateEmail(@RequestBody Email email, @PathVariable("id") Long id) 
    {
        System.out.println(email);
        
        if(email != null || id > 0)
        {
            email.setEmailid(id);

            Email updatedEmail = emailService.updateEmailByUserId(email);

            return new ResponseEntity<>(updatedEmail, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }
}
