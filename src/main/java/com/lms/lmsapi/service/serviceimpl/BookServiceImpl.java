package com.lms.lmsapi.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsapi.entity.Book;
import com.lms.lmsapi.exception.BookNotFoundException;
import com.lms.lmsapi.repository.BookRepository;
import com.lms.lmsapi.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks()
    {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book)
    {
        if (book != null) 
        {
            return bookRepository.save(book);
        }
        else{
            throw new BookNotFoundException("Book object not created.");
        }
    }

    @Override
    public Book getBookById(Long id)
    {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) 
        {
            return optionalBook.get();            
        }
        else{
            throw new BookNotFoundException("Book not found.");
        }
    }

    @Override
    public Book updateBook(Book book)
    {
        Book existingBook = bookRepository.findById(book.getBookid()).get();

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setYearpublished(book.getYearpublished());
        existingBook.setAvailablecopies(book.getAvailablecopies());
        existingBook.setBookcatid(book.getBookcatid());
        existingBook.setUserid(book.getUserid());
        existingBook.setCreatedDt(book.getCreatedDt());
        existingBook.setModifiedDt(book.getModifiedDt());

        Book updatedBook = bookRepository.save(existingBook);

        return updatedBook; 
    }

    @Override
    public void deleteBook(Long bookId)
    {
        bookRepository.deleteById(bookId);
    }
}
