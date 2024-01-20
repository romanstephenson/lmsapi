package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Email")

public class  Email implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn (name="id",insertable = false, updatable = false)
    private User userId;

    @Column(nullable = false)
    private String emailAddress; 

    @Column(nullable = false)
    private int isPrimary;

    @Column(nullable = true)
    private Date createdDt;

    @Column(nullable = true)
    private Date modifiedDt;
}
