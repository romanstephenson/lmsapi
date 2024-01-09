package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int BookId;

    public String Title;

    public String Author;

    public String Description;

    public String Publisher;

    public String Isbn;

    public Date YearPublished;

    public int AvailableCopies;

    @OneToOne
    @JoinColumn(name = "Id")
    public BookCategory CategoryId;

    @OneToOne
    @JoinColumn(name = "Id")
    public User AddedBy;

    public Date CreatedDt;

    public Date ModifiedDt;
    
}
