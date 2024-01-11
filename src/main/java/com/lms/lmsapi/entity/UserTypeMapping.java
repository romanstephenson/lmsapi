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
@Table(name = "User_Type_Mapping")

public class UserTypeMapping 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    //@OneToOne(mappedBy = "User")
    @OneToOne
    @JoinColumn(name="Id")
    private User user;

    //@OneToOne(mappedBy = "User_Type")
    @OneToOne
    @JoinColumn(name="Id")
    private UserType userType;

    private Date CreatedDt;

    private Date ModifiedDt;
}
