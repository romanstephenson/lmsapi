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
@JsonPropertyOrder({"depid","departmentname","createdDt","modifiedDt"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Department")
public class Department implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("depid")
    private Long depid;

    @Column(nullable = false)
    private String departmentname;

    @OneToOne
    @JsonProperty("facultyid")
    @JoinColumn(name = "facultyid", insertable = true, updatable = false)
    private Faculty facultyid;

    @Column(nullable = false)
    private Date createdDt;

    @Column(nullable = false)
    private Date modifiedDt;

}