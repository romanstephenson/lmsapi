package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Type")
public class UserType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;

    public String Name;

    public int Status;

    public String Description;

    public Date CreatedDt;

    public Date ModifiedDt;

}
