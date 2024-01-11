package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.service.*;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    private UserTypeService userTypeService;
    private StudentCategoryService studentCategoryService;

    @Autowired
    public void setUserTypeService(UserTypeService UserTypeService) {this.userTypeService = UserTypeService;}
    public void setStudentCategoryService(StudentCategoryService StudentCategoryService) { this.studentCategoryService = StudentCategoryService;}

    @GetMapping(value = "/usertypes")
    public ResponseEntity<List<UserType>> getAllUserTypes()
    {
        List<UserType> userTypes = userTypeService.getUserTypes();

        return new ResponseEntity<>(userTypes, HttpStatus.OK);
    }

    @GetMapping(value = "/studentcategories")
    public ResponseEntity<List<StudentCategory>> getStudentCategories()
    {
        List<StudentCategory> studentCategories = studentCategoryService.getStudentCategories();

        return new ResponseEntity<>(studentCategories, HttpStatus.OK);
    }
    
}
