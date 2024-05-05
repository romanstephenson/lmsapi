package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.service.*;

//import lombok.extern.slf4j.Slf4j;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RestController
@RequestMapping(value = "/lmsapi")
public class IdentityPassController 
{
    // private IdentityPassService identityPassService;

    // @Autowired
    // public void setIdentityPassService(IdentityPassService identityPassService)
    // {
    //     this.identityPassService = identityPassService;
    // }

    // @PostMapping(value = "/v1/activeidentitypass")
    // public ResponseEntity<IdentityPass> getActiveIdentityPass(User userid)
    // {
    //     System.out.println(userid);

    //     if( userid != null )
    //     {
    //         IdentityPass identityPass = identityPassService.findByUseridAndIsactive(userid);

    //         return new ResponseEntity<>(identityPass, HttpStatus.OK);
    //     }

    //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    
} 
