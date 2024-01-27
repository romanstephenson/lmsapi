package com.lms.lmsapi.entity;

import java.sql.Date;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book")
public class Book 
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
    @JoinColumn(name = "bookcatid",insertable = false, updatable = false)
    private BookCategory bookcatid;

    @OneToOne
    @JoinColumn(name = "userid",insertable = false, updatable = false)
    private User userid;

    private Date createdDt;

    private Date modifiedDt;
}
