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
public class BookController 
{
    private BookService bookService;

    @Autowired
    public void bookService(BookService BookService){ this.bookService = BookService; }

    @GetMapping(value = "/v1/books")
    public ResponseEntity<List<Book>> getAllBooks()
    {
        List<Book> books = bookService.getBooks();

        if (books.isEmpty()) 
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);    
        } 
        
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id)
    {
        if(id > 0 )
        {
            Book book = bookService.getBookById(id);

            return new ResponseEntity<>(book, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @PostMapping(value = "/v1/createbook")
    public ResponseEntity<Book> createBook(@RequestBody Book book)
    {
        if(book != null)
        {
            Book savedBook = bookService.createBook(book);

            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/v1/updatebook/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Long id)
    {
        if(book != null || id > 0)
        {
            book.setBookid(id);

            Book updatedBook = bookService.updateBook(book);

            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
