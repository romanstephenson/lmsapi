package com.lms.lmsapi.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false)
    private String Firstname;

    @Column(nullable = false)
    private String Middlename;

    @Column(nullable = false)
    private String Lastname;

    @Column(nullable = false)
    private String Username;

    @Column(nullable = false)
    private Date Dob;

    @Column(nullable = false)
    private String Gender;

    @Column(nullable = false)
    private int ChangePass;

    @Column(nullable = false)
    private int IsActive;

    @Column(nullable = true)
    private Date CreatedDt; 

    @Column(nullable = true)
    private Date ModifiedDt;

    @OneToMany
    @JoinColumn(name="UserId")
    @Builder.Default
    private Set<Email> Email = new HashSet<Email>();;

    @OneToOne
    @JoinColumn(name = "Id")
    private UserType userType;

    
}
