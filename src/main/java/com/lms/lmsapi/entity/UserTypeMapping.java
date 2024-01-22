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
    private Long usertypemappingid;

    @OneToOne
    @JoinColumn(name="userid")
    private User userId;

    @OneToOne
    @JoinColumn(name="usertypeid")
    private UserType userType;

    private Date createdDt;

    private Date modifiedDt;
}
