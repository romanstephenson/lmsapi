package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Student 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int StudentId;

    @OneToOne
    @JoinColumn(name = "Id")
    public StudentCategory Category;

    @OneToOne
    @JoinColumn(name = "Id")
    public Faculty StudentFaculty;

    public int Year;

    public Date CreatedDt;

    public Date ModifiedDt;
}
