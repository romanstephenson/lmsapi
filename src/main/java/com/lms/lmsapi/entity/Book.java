package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book")
public class Book 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookId;

    private String Title;

    private String Author;

    private String Description;

    private String Publisher;

    private String Isbn;

    private Date YearPublished;

    private int AvailableCopies;

    @OneToOne
    @JoinColumn(name = "Id")
    private BookCategory bookCategory;

    @OneToOne
    @JoinColumn(name = "Id")
    private User AddedBy;

    private Date CreatedDt;

    private Date ModifiedDt;

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String isbn) {
        Isbn = isbn;
    }

    public Date getYearPublished() {
        return YearPublished;
    }

    public void setYearPublished(Date yearPublished) {
        YearPublished = yearPublished;
    }

    public int getAvailableCopies() {
        return AvailableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        AvailableCopies = availableCopies;
    }

    public BookCategory getCategoryId() {
        return bookCategory;
    }

    public void setCategoryId(BookCategory BookCategory) {
        bookCategory = BookCategory;
    }

    public User getAddedBy() {
        return AddedBy;
    }

    public void setAddedBy(User addedBy) {
        AddedBy = addedBy;
    }

    public Date getCreatedDt() {
        return CreatedDt;
    }

    public void setCreatedDt(Date createdDt) {
        CreatedDt = createdDt;
    }

    public Date getModifiedDt() {
        return ModifiedDt;
    }

    public void setModifiedDt(Date modifiedDt) {
        ModifiedDt = modifiedDt;
    }
}
