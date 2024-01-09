package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class StudentCategory 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CatId;

    private String Category;

    private int MaxAllowed;

    private Date CreatedDt;

    private Date ModifiedDt;
}
