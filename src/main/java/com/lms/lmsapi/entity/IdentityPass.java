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
@Table(name = "IdentityPass")
public class IdentityPass 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String Password;

    private boolean IsActive;

    @ManyToOne
    @JoinColumn(name = "Id",insertable = false, updatable = false)
    private User Owner;

    private int ValidTill;

    private Date CreatedDt;

    private Date ModifiedDt;
    
}
