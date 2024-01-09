package com.lms.lmsapi.entity;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.OneToOne;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Type_Mapping")

public class UserTypeMapping 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToOne(mappedBy = "User")
    @JoinColumn(name="Id")
    private User UserId;

    @OneToOne(mappedBy = "User_Type")
    @JoinColumn(name="Id")
    private UserType UserType;

    private Date CreatedDt;

    private Date ModifiedDt;
}
