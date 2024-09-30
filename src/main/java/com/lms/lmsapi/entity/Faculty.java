package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"facultyid","facultyid","facultyname","createdDt","modifiedDt"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Faculty")
public class Faculty implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("facultyid")
    private Long facultyid;

    @Column(nullable = false)
    private String facultyname;

    @Column(nullable = false)
    private Date createdDt;

    @Column(nullable = false)
    private Date modifiedDt;
}
