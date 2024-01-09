package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Faculty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    public String FacultyName;

    public Date CreatedDt;

    public Date ModifiedDt;
}
