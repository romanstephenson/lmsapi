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
@Table(name = "Book")
public class Book 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String title;

    private String author;

    private String description;

    private String publisher;

    private String isbn;

    private Date yearPublished;

    private int availableCopies;

    @OneToOne
    @JoinColumn(name = "Id",insertable = false, updatable = false)
    private BookCategory bookCategory;

    @OneToOne
    @JoinColumn(name = "Id",insertable = false, updatable = false)
    private User addedBy;

    private Date createdDt;

    private Date modifiedDt;
}
