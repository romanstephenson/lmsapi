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
public class StudentCategoryController 
{
    private StudentCategoryService studentCategoryService;

    @Autowired
    public void setStudentCategoryService(StudentCategoryService StudentCategoryService) { this.studentCategoryService = StudentCategoryService; }

    /**
     * Get all student categories in DB
     * @return returns a List of Student Categories
     */
    @GetMapping(value = "/v1/studentcategories")
    public ResponseEntity<List<StudentCategory>> getStudentCategories()
    {
        List<StudentCategory> studentCategories = studentCategoryService.getStudentCategories();

        if(studentCategories.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(studentCategories, HttpStatus.OK);
    }

    
    /**Gets a student category based on ID
     * @param Id
     * @return StudentCategory object
     */
    @GetMapping(value = "/v1/studentcategory/{id}")
    public ResponseEntity<StudentCategory> getStudentCategory(@PathVariable("id")  Long Id)
    {
        if(Id > 0 )
        {
            StudentCategory studentCategory = studentCategoryService.getStudentCategory(Id);

            return new ResponseEntity<>(studentCategory, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
