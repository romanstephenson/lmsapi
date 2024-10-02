package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
import com.lms.lmsapi.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
