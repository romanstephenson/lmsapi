package com.lms.lmsapi.entity;

import java.sql.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@data used to auto configure getters and setters automatically
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Type")
public class UserType 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usertypeid;

    private String name;

    private int status;

    private String description;

    private Date createdDt;

    private Date modifiedDt;
}
