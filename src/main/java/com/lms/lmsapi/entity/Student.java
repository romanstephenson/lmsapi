package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.*;


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
    @OneToOne(mappedBy = "User")
	@JoinColumn (name="Id")
    private User StudentId;

    @OneToOne
    @JoinColumn(name = "Id")
    private StudentCategory Category;

    @OneToOne
    @JoinColumn(name = "Id")
    private Faculty StudentFaculty;

    private int Year;

    private Date CreatedDt;

    private Date ModifiedDt;
}
