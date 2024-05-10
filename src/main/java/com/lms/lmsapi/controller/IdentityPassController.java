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

    @PostMapping(value = "/v1/createidentitypass")
    public ResponseEntity<IdentityPass> createidentitypass(@RequestBody IdentityPass identitypass) 
    {
        if(identitypass != null)
        {
            IdentityPass savedIdentityPass = identityPassService.createIdentityPass(identitypass);

            return new ResponseEntity<>(savedIdentityPass, HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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

     /** updates an existing password for a user
     * @param identity
     * @return returns updated identity pass object
     */
    @PutMapping(value = "/v1/updateidentity/{id}")
    public ResponseEntity<IdentityPass> updateIdentityPass(@RequestBody IdentityPass identityPass, @PathVariable Long id) 
    {
        System.out.println(identityPass);
        
        if(identityPass != null && id > 0)
        {
            identityPass.setIdentpassid(id);

            IdentityPass updatedIdentityPass = identityPassService.updatIdentityPass(identityPass);

            return new ResponseEntity<>(updatedIdentityPass, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }
    
} 
