package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.*;

public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
	@JoinColumn (name="Id")
    private User UserId;

    private String EmailAddress;

    private int IsPrimary;

    private Date CreatedDt;

    private Date ModifiedDt;
}
