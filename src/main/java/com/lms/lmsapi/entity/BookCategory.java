package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BookCategory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    public String Category;

    public Date CreatedDt;

    public Date ModifiedDt;

}
