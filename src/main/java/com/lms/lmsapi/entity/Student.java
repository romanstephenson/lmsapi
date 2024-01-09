package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Student 
{
    @Id
    @OneToOne(mappedBy = "User")
	@JoinColumn (name="Id")
    private User StudentId;

    @OneToOne
    @JoinColumn(name = "Id")
    private StudentCategory Category;

    @OneToOne
    @JoinColumn(name = "Id")
    private Faculty StudentFaculty;

    private int Year;

    private Date CreatedDt;

    private Date ModifiedDt;
}
