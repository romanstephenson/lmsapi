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
public class StudentController 
{
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService StudentService){ this.studentService = StudentService; }
    
    

     /** Creates student 
     * @param student
     * @return returns a created student that must already be a user
     */
    @PostMapping(value = "/v1/createstudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        System.out.println(student);

        if(student != null)
        {
            Student savedStudent = studentService.createStudent(student);

            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }
    
}
