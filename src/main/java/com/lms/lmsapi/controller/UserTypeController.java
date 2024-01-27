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
public class UserTypeController 
{
    private UserTypeService userTypeService;

    @Autowired
    public void setUserTypeService(UserTypeService UserTypeService) {this.userTypeService = UserTypeService; }

    /**
     * Get All userTypes defined in databsae
     * @return List of Usertype
     */
    @GetMapping(value = "/v1/usertypes")
    public ResponseEntity<List<UserType>> getAllUserTypes()
    {
        List<UserType> userTypes = userTypeService.getUserTypes();


        if(userTypes.isEmpty())
        {
            //log.error("No user types were found.");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        //log.info("user types found: "+ userTypes);
        return new ResponseEntity<>(userTypes, HttpStatus.OK);
    }


    /**
     * Get a specific user type based on ID
     * @param Id
     * @return return usertype associated with ID passed in
     */
    @GetMapping(value = "/v1/usertype/{id}")
    public ResponseEntity<UserType> getUserType(@PathVariable("id")  Long Id)
    {
        UserType userType = userTypeService.getUserType(Id);

        if(userType == null)
        {
            log.error("No user type were found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.info("user types found: "+ userType);
        return new ResponseEntity<>(userType, HttpStatus.OK);
    }


    /**
     * Create a user type
     * @param userType
     * @return
     */
    @PostMapping(value = "/v1/createusertype")
    public ResponseEntity<UserType> createUserType(@RequestBody UserType userType)
    {
       // System.out.println(userType);

        if(userType != null)
        {
            UserType savedUserType = userTypeService.createUserType(userType);

            return new ResponseEntity<>(savedUserType, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }
}
