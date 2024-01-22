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

@Table(name = "Verification")
public class Verification 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verid;

    private int verificationStatus;

    private String verificationToken;

    @ManyToOne
    @JoinColumn(name = "userid",insertable = false, updatable = false)
    private User owner;

    private Date createdDt;

    private Date verifiedDt;
    
}
