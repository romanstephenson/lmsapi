package com.lms.lmsapi.controller;

import com.lms.lmsapi.entity.*;
//import com.lms.lmsapi.exception.*;
import com.lms.lmsapi.service.*;

import lombok.AllArgsConstructor;

import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/lmsapi")
public class LmsController 
{
    private UserTypeService userTypeService;
    private StudentCategoryService studentCategoryService;
    private BookCategoryService bookCategoryService;
    private FacultyService facultyService;
    private UserService userService;
    private EmailService emailService;

    @Autowired
    public void setUserTypeService(UserTypeService UserTypeService) {this.userTypeService = UserTypeService; }
    public void setStudentCategoryService(StudentCategoryService StudentCategoryService) { this.studentCategoryService = StudentCategoryService; }
    public void setBookCategoryService(BookCategoryService BookCategoryService){this.bookCategoryService = BookCategoryService; }
    public void setFacultyService(FacultyService FacultyService){ this.facultyService = FacultyService;}
    public void setUserService(UserService UserService){ this.userService = UserService; }
    public void setEmailService(EmailService EmailService){ this.emailService = EmailService; }

    
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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(userTypes, HttpStatus.OK);
    }


    /**
     * Get a specific user type based on ID
     * @param Id
     * @return return usertype associated with ID passed in
     */
    @GetMapping(value = "/v1/usertype/{id}")
    public ResponseEntity<UserType> getUserType(@PathVariable("id")  int Id)
    {
        UserType userType = userTypeService.getUserType(Id);

        if(userType == null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

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

    
    /** Creates an email address for a user
     * @param email
     * @return returns created email object
     */
    @PostMapping(value = "/v1/createuseremail")
    public ResponseEntity<Email> createEmail(@RequestBody Email email) 
    {
        
        if(email != null)
        {
            Email savedEmail = emailService.createUserEmail(email);

            return new ResponseEntity<>(savedEmail, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }
    

    
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
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(studentCategories, HttpStatus.OK);
    }

    
    /**Gets a student category based on ID
     * @param Id
     * @return StudentCategory object
     */
    @GetMapping(value = "/v1/studentcategory/{id}")
    public ResponseEntity<StudentCategory> getStudentCategory(@PathVariable("id")  int Id)
    {
        if(Id > 0 )
        {
            StudentCategory studentCategory = studentCategoryService.getStudentCategory(Id);

            return new ResponseEntity<>(studentCategory, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    


    /**Get all book categories
     * @return returns a list of book categories of type BookCategory
     */
    @GetMapping(value = "/v1/bookcategories")
    public ResponseEntity<List<BookCategory>> getBookCategories()
    {
        List<BookCategory> bookCategories = bookCategoryService.getBookCategories();

        if(bookCategories.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<>(bookCategories, HttpStatus.OK);
    }

    /**Gets book category based on ID
     * @param Id
     * @return returns BookCategory object
     */
    @GetMapping(value = "/v1/bookcategory/{id}")
    public ResponseEntity<BookCategory> getBookCategory(@PathVariable("id")  int Id)
    {
        if(Id > 0)
        {
            BookCategory bookCategory = bookCategoryService.getBookCategory(Id);

            return new ResponseEntity<>(bookCategory, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }


    /** Creates book category
     * @param bookCategory
     * @return returns a BookCategory object
     */
    @PostMapping(value = "/v1/createbookcategory")
    public ResponseEntity<BookCategory> createBookCategory(@RequestBody BookCategory bookCategory)
    {
        System.out.println(bookCategory);

        if(bookCategory != null)
        {
            BookCategory savedBookCategory = bookCategoryService.createBookCategory(bookCategory);

            return new ResponseEntity<>(savedBookCategory, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
    }


    /**Gets all faculties
     * @return List of Faculty Objects
     */
    @GetMapping(value = "/v1/faculties")
    public ResponseEntity<List<Faculty>> getFaculties()
    {

        List<Faculty> faculties = facultyService.getFaculties();

        if(faculties.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }

    
    /**Gets a faculty based on ID
     * @param Id
     * @return returns a Facult object
     */
    @GetMapping(value = "/v1/faculty/{id}")
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
