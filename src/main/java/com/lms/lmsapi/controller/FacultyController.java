package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.exception.FacultyNotFoundException;
import com.lms.lmsapi.service.*;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/lmsapi")
public class FacultyController 
{
    private FacultyService facultyService;

    @Autowired
    public void setFacultyService(FacultyService FacultyService){ this.facultyService = FacultyService;}

    /**Gets all faculties
     * @return List of Faculty Objects
     */
    @GetMapping(value = "/v1/faculties")
    public ResponseEntity<List<Faculty>> getFaculties()
    {

        List<Faculty> faculties = facultyService.getFaculties();

        if(faculties.isEmpty())
        {
            log.info("Found faculties with info: " + faculties);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.warn("No faculties found.");
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    
    /**Gets a faculty based on ID
     * @param Id
     * @return returns a Facult object
     */
    @GetMapping(value = "/v1/faculty/{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable("id") Long Id)
    {
        try 
        {
            return new ResponseEntity<Faculty>(facultyService.getFaculty(Id), HttpStatus.OK);
        } 
        catch (FacultyNotFoundException e) 
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }       
    }

    
    /**Create faculty
     * @return List of Faculty Objects
     */
    @PostMapping(value = "/v1/createfaculty")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty)
    {

        if(faculty != null)
        {
            Faculty savedFaculty = facultyService.createFaculty(faculty);

            return new ResponseEntity<>(savedFaculty,HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
