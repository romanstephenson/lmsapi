package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.exception.*;
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
    private BookCategoryService bookCategoryService;
    private FacultyService facultyService;

    @Autowired
    public void setUserTypeService(UserTypeService UserTypeService) {this.userTypeService = UserTypeService; }
    public void setStudentCategoryService(StudentCategoryService StudentCategoryService) { this.studentCategoryService = StudentCategoryService; }
    public void setBookCategoryService(BookCategoryService BookCategoryService){this.bookCategoryService = BookCategoryService; }
    public void setFacultyService(FacultyService FacultyService){ this.facultyService = FacultyService;}


    @GetMapping(value = "/usertypes")
    public ResponseEntity<List<UserType>> getAllUserTypes()
    {
        List<UserType> userTypes = userTypeService.getUserTypes();

        return new ResponseEntity<>(userTypes, HttpStatus.OK);
    }

    @GetMapping(value = "/usertype/{id}")
    public ResponseEntity<UserType> getUserType(@PathVariable("id")  int Id)
    {
        UserType userType = userTypeService.getUserType(Id);

        return new ResponseEntity<>(userType, HttpStatus.OK);
    }

    @GetMapping(value = "/studentcategories")
    public ResponseEntity<List<StudentCategory>> getStudentCategories()
    {
        List<StudentCategory> studentCategories = studentCategoryService.getStudentCategories();

        return new ResponseEntity<>(studentCategories, HttpStatus.OK);
    }

    @GetMapping(value = "/studentcategory/{id}")
    public ResponseEntity<StudentCategory> getStudentCategory(@PathVariable("id")  int Id)
    {
        StudentCategory studentCategory = studentCategoryService.getStudentCategory(Id);

        return new ResponseEntity<>(studentCategory, HttpStatus.OK);
    }
    
    @GetMapping(value = "/bookcategories")
    public ResponseEntity<List<BookCategory>> getBookCategories()
    {
        
        try 
        {
            List<BookCategory> bookCategories = bookCategoryService.getBookCategories();

            return new ResponseEntity<>(bookCategories, HttpStatus.OK);
        } 
        catch (Exception e) 
        {
             return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping(value = "/bookcategory/{id}")
    public ResponseEntity<BookCategory> getBookCategory(@PathVariable("id")  int Id)
    {
        BookCategory bookCategory = bookCategoryService.getBookCategory(Id);

        if(bookCategory != null)
        {
            return new ResponseEntity<>(bookCategory, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }


    @GetMapping(value = "/faculties")
    public ResponseEntity<List<Faculty>> getFaculties()
    {
        try
        {
            List<Faculty> faculties = facultyService.getFaculties();

            return new ResponseEntity<>(faculties, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/faculty/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable("id") int Id)
    {
        Faculty faculty = facultyService.getFaculty(Id);

        if (faculty != null) 
        {
            return new ResponseEntity<>(faculty,HttpStatus.OK);    
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        }
    }
}
