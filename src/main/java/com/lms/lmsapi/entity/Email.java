package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.*;

public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    public int UserId;

    public String EmailAddress;

    public byte IsPrimary;

    public Date CreatedDt;

    public Date ModifiedDt;
}
