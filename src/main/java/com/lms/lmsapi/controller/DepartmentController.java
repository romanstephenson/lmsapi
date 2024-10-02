package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/lmsapi")
public class DepartmentController 
{
    private DepartmentService departmentService;

    @Autowired
    public void departmentService(DepartmentService DepartmentService){ this.departmentService = DepartmentService; }

    @GetMapping(value = "/v1/departments")
    public ResponseEntity<List<Department>> getDepartments()
    {
        List<Department> departments = departmentService.getDepartments();

        if(departments.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/department/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id)
    {
        if(id > 0 )
        {
            Department department = departmentService.getDepartment(id);

            return new ResponseEntity<>(department, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @PostMapping(value = "/v1/createdepartment")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department)
    {
        if(department != null)
        {
            Department savedDepartment = departmentService.createDepartment(department);

            return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
