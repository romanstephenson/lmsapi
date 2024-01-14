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
    private int id;

    private String password;

    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "Id",insertable = false, updatable = false)
    private User owner;

    private int validTill;

    private Date createdDt;

    private Date modifiedDt;
    
}
