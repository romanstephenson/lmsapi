package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name","status","description","createdDt","modifiedDt"})
//@data used to auto configure getters and setters automatically
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Type")
public class UserType implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("usertypeid")
    private Long usertypeid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Date createdDt;

    @Column(nullable = false)
    private Date modifiedDt;
}
