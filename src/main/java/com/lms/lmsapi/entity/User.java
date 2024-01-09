package com.lms.lmsapi.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Firstname;

    private String Middlename;

    private String Lastname;

    private String Username;

    private Date Dob;

    private String Gender;

    private int ChangePass;

    private int IsActive;

    private Date CreatedDt; 

    private Date ModifiedDt;

    @OneToMany(mappedBy = "Email")
    @JoinColumn(name="UserId")
    @Builder.Default
    private Set<Email> Email = new HashSet<Email>();;

    @OneToOne
    @JoinColumn(name = "Id")
    private UserType userType;

    
}
