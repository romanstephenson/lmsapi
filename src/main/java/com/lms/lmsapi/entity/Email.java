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
@Table(name = "Email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
	@JoinColumn (name="Id",insertable = false, updatable = false)
    private User UserId;

    private String EmailAddress;

    private int IsPrimary;

    private Date CreatedDt;

    private Date ModifiedDt;
}
