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
    private int Id;

    private int VerificationStatus;

    private String VerificationToken;

    @ManyToOne
    @JoinColumn(name = "Id",insertable = false, updatable = false)
    private User Owner;

    private Date CreatedDt;

    private Date VerifiedDt;
    
}
