package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Faculty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String FacultyName;

    private Date CreatedDt;

    private Date ModifiedDt;
}
