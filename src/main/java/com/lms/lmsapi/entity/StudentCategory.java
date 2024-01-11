package com.lms.lmsapi.entity;

import java.sql.Date;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student_Category")
public class StudentCategory 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CatId;

    private String Category;

    private int MaxAllowed;

    private Date CreatedDt;

    private Date ModifiedDt;
}
 