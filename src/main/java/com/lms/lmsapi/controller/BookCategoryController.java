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
public class BookCategoryController 
{
    private BookCategoryService bookCategoryService;

     @Autowired
    public void setBookCategoryService(BookCategoryService BookCategoryService){this.bookCategoryService = BookCategoryService; }


    /**Get all book categories
     * @return returns a list of book categories of type BookCategory
     */
    @GetMapping(value = "/v1/bookcategories")
    public ResponseEntity<List<BookCategory>> getBookCategories()
    {
        List<BookCategory> bookCategories = bookCategoryService.getBookCategories();

        if(bookCategories.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(bookCategories, HttpStatus.OK);
    }

    
    /**Gets book category based on ID
     * @param Id
     * @return returns BookCategory object
     */
    @GetMapping(value = "/v1/bookcategory/{id}")
    public ResponseEntity<BookCategory> getBookCategory(@PathVariable("id")  Long Id)
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
    
}
