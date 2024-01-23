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
@Table(name = "Student_Category")
public class StudentCategory implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("catid")
    private Long catid;

    private String category;

    private Long maxAllowed;

    private Date createdDt;

    private Date modifiedDt;
}
 