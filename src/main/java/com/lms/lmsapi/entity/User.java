package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("userid")
    private Long userid;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String middlename;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private int changePass;

    @Column(nullable = false)
    private int isActive;

    @Column(nullable = true)
    private Date createdDt; 

    @Column(nullable = true)
    private Date modifiedDt;

}
