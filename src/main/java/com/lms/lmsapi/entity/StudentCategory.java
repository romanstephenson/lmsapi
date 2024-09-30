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
@JsonPropertyOrder({"category","maxAllowed","createdDt","modifiedDt"})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student_Category")
public class StudentCategory implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("catid")
    private Long catid;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Long maxAllowed;

    @Column(nullable = false)
    private Date createdDt;

    @Column(nullable = false)
    private Date modifiedDt;
}
 