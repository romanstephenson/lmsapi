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
@JsonPropertyOrder({"bookid","title","author","description","publisher","isbn","yearpublished","availablecopies","bookcatid","userid","createdDt","modifiedDt"})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookid;

    private String title;

    private String author;

    private String description;

    private String publisher;

    private String isbn;

    private Date yearpublished;

    private Long availablecopies;

    @OneToOne
    @JsonProperty("bookcatid")
    @JoinColumn(name = "bookcatid",insertable = true, updatable = false)
    private BookCategory bookcatid;

    @OneToOne
    @JsonProperty("userid")
    @JoinColumn(name = "userid",insertable = true, updatable = false)
    private User userid;

    private Date createdDt;

    private Date modifiedDt;
}
