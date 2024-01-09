package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jakarta.persistence.OneToOne;

public class BookIssueLog 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "BookId")
    private Book Book;

    @OneToOne
    @JoinColumn(name = "StudentId")
    private Student IssuedTo;

    @OneToOne
    @JoinColumn(name = "StaffId")
    private Staff IssuedBy;

    private Date IssueDt;

    private Date ReturnDt;

    private Date ModifiedDt;
}
