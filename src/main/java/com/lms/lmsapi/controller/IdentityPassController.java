package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.exception.FacultyNotFoundException;
import com.lms.lmsapi.exception.IdentityPassNotFoundException;
import com.lms.lmsapi.service.*;

import java.util.Optional;

//import lombok.extern.slf4j.Slf4j;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//@Slf4j
@RestController
@RequestMapping(value = "/lmsapi")
public class IdentityPassController 
{
    private IdentityPassService identityPassService;

    @Autowired
    public void setIdentityPassService(IdentityPassService identityPassService)
    {
        this.identityPassService = identityPassService;
    }

    @GetMapping(value = "/v1/identitypass/{userid}")
    public ResponseEntity<IdentityPass> getIdentPass(@PathVariable("userid") Long userid)
    {
        try 
        {
            return new ResponseEntity<IdentityPass>(identityPassService.getIdentityPass(userid), HttpStatus.OK);
        } 
        catch (IdentityPassNotFoundException e) 
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }     

    }


    @GetMapping(value = "/v1/activeidentitypass/{userid}")
    public ResponseEntity<IdentityPass> getActiveIdentityPass(@PathVariable("userid") Long userid)
    {
        System.out.println(userid);

        try {
            return new ResponseEntity<IdentityPass>(identityPassService.getIdentityPassActive(userid), HttpStatus.OK);
            
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
} 
