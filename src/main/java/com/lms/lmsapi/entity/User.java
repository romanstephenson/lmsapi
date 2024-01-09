package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    public String Firstname ;

    public String Middlename;

    public String Lastname;

    public String Username;

    public Date Dob;

    public String Gender;

    public int ChangePass;

    public int IsActive;

    public Date CreatedDt; 

    public Date ModifiedDt;

    @ManyToOne
    @JoinColumn(name="UserId")
    public Email Email;

    @OneToOne
    @JoinColumn(name = "Id")
    public UserType UserType;

}
