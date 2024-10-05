package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.exception.FacultyNotFoundException;
import com.lms.lmsapi.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/lmsapi")
public class StaffController 
{
    private StaffService staffService;

    @Autowired
    public void setStaffService(StaffService StaffService) { this.staffService = StaffService; }

    /* Creates staff
     * @param staff
     * @return returns a created staff record that must already be a user
     */
    @PostMapping(value="/v1/createstaff")
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff)
    {
        if(staff != null)
        {
            Staff savedStaff = staffService.createStaff(staff);

            return new ResponseEntity<>(savedStaff, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**Gets all staff members
     * @return List of staff Objects
     */
    @GetMapping(value = "/v1/staffs")
    public ResponseEntity<List<Staff>> getStaffs()
    {

        List<Staff> staffs = staffService.getStaffs();

        if(staffs.isEmpty())
        {
            //log.info("Found faculties with info: " + faculties);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //log.warn("No faculties found.");
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

     /**Gets a staff member based on ID
     * @param Id
     * @return returns a staff object
     */
    @GetMapping(value = "/v1/staff/{id}")
    public ResponseEntity<Staff> getFaculty(@PathVariable("id") Long Id)
    {
        try 
        {
            return new ResponseEntity<Staff>(staffService.getStaff(Id), HttpStatus.OK);
        } 
        catch (FacultyNotFoundException e) 
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }       
    }

}
