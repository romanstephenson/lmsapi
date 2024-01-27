package com.lms.lmsapi.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsapi.entity.BookCategory;
import com.lms.lmsapi.repository.BookCategoryRepository;
import com.lms.lmsapi.service.BookCategoryService;
import com.lms.lmsapi.exception.BookCategoryNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService 
{
    
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategory> getBookCategories()
    {
        return (List<BookCategory>) bookCategoryRepository.findAll();
    }

    @Override
    public BookCategory createBookCategory(BookCategory bookCategory)
    {
        if(bookCategory != null)
        {
            return bookCategoryRepository.save(bookCategory);
        }
        else{
            throw new BookCategoryNotFoundException("Book category object not created correctly.");
        }
    }

    @Override
    public BookCategory getBookCategory(Long Id)
    {
        Optional<BookCategory> optionalBookCategory = bookCategoryRepository.findById(Id);

        if(optionalBookCategory.isPresent())
        {
            return optionalBookCategory.get();
        }
        else
        {
            throw new BookCategoryNotFoundException("Book Category not found.");
        }
    }

    @Override
    public BookCategory updateBookCategory(BookCategory bookCategory)
    {
        BookCategory existinBookCategory = bookCategoryRepository.findById(bookCategory.getBookcatid()).get();

        existinBookCategory.setCategory(bookCategory.getCategory());
        existinBookCategory.setModifiedDt(bookCategory.getModifiedDt());

        BookCategory updatedBookCategory = bookCategoryRepository.save(existinBookCategory);

        return updatedBookCategory;
    }


    @Override
    public void deleteBookCategory(Long bookCategoryId)
    {
        bookCategoryRepository.deleteById(bookCategoryId);
    }
}
