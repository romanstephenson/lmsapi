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
@JsonPropertyOrder({"userid","catid","facultyid","year","createdDt","modifiedDt"})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student")
public class Student implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonProperty("userid")
	@JoinColumn (name="userid",insertable = true, updatable = false)
    private User userid;

    @OneToOne
    @JsonProperty("catid")
    @JoinColumn(name = "catid",insertable = true, updatable = false)
    private StudentCategory catid;

    @OneToOne
    @JsonProperty("facultyid")
    @JoinColumn(name = "facultyid",insertable = true, updatable = false)
    private Faculty facultyid;

    @Column(nullable = false)
    private Long year;

    @Column(nullable = false)
    private Date createdDt;

    @Column(nullable = false)
    private Date modifiedDt;
}
