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
public class UserController 
{
    private UserService userService;

    @Autowired
    public void setUserService(UserService UserService){ this.userService = UserService; }

    /**
     * Get All users defined in databsae
     * @return List of Users
     */
    @GetMapping(value = "/v1/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.getUsers();

        if(users.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    /**
     * Get a specific user based on ID
     * @param Id
     * @return return user associated with ID passed in
     */
    @GetMapping(value = "/v1/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id")  Long Id)
    {
        User user = userService.getUserById(Id);

        if(user == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }



    /** Creates a user
     * @param user
     * @return returns created User object
     */
    @PostMapping(value = "/v1/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        if(user != null)
        {
            User savedUser = userService.createUser(user);

            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
