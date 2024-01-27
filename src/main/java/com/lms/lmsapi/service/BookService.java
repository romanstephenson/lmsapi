package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.Book;

public interface BookService {

    List<Book> getBooks();
    Book getBookById(Long Id);
    Book createBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Long book);
}