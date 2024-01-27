package com.lms.lmsapi.entity;

import java.sql.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Staff")
public class Staff 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
	@JoinColumn (name="userid",insertable = false, updatable = false)
    private User userid;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private Date hireStartDt;

    @Column(nullable = false)
    private Date hireEndDt;

    @Column(nullable = false)
    private Date createdDt;

    @Column(nullable = false)
    private Date modifiedDt;
}
