package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.exception.*;
import com.lms.lmsapi.repository.*;
import com.lms.lmsapi.service.*;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/lmsapi/v1")
public class LmsController 
{

    private UserService UserService;
    private UserTypeService userTypeService;
    private EmailService emailService;

    @GetMapping(value = "/userTypes")
    public ResponseEntity<List<UserType>> getAllUserTypes()
    {
        List<UserType> userTypes = userTypeService.getUserTypes();

        return new ResponseEntity<>(userTypes, HttpStatus.OK);
    }
    
}
