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
    @OneToOne
	@JoinColumn (name="userid",insertable = false, updatable = false)
    private User studentId;

    @OneToOne
    @JoinColumn(name = "catid",insertable = false, updatable = false)
    private StudentCategory category;

    @OneToOne
    @JoinColumn(name = "facultyid",insertable = false, updatable = false)
    private Faculty studentFaculty;

    private int year;

    private Date createdDt;

    private Date modifiedDt;
}
