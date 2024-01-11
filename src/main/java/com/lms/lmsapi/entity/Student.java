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
@Table(name = "Student")
public class Student 
{
    @Id
    //@OneToOne(mappedBy = "User")
    @OneToOne
	@JoinColumn (name="Id")
    private User StudentId;

    @OneToOne
    @JoinColumn(name = "Id",insertable = false, updatable = false)
    private StudentCategory Category;

    @OneToOne
    @JoinColumn(name = "Id",insertable = false, updatable = false)
    private Faculty StudentFaculty;

    private int Year;

    private Date CreatedDt;

    private Date ModifiedDt;
}
