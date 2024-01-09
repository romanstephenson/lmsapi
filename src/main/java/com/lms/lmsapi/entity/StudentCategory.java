package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class StudentCategory 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int CatId;

    public String Category;

    public int MaxAllowed;

    public Date CreatedDt;

    public Date ModifiedDt;
}
