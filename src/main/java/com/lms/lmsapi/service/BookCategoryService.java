package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.BookCategory;

public interface BookCategoryService 
{
    List<BookCategory> getBookCategories();
    BookCategory getBookCategory(Long Id);
    BookCategory createBookCategory(BookCategory bookCategory);
    BookCategory updateBookCategory(BookCategory bookCategory);
    void deleteBookCategory(Long bookCategory);
}
