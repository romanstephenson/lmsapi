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
    private int BookId;

    private String Title;

    private String Author;

    private String Description;

    private String Publisher;

    private String Isbn;

    private Date YearPublished;

    private int AvailableCopies;

    @OneToOne
    @JoinColumn(name = "Id",insertable = false, updatable = false)
    private BookCategory bookCategory;

    @OneToOne
    @JoinColumn(name = "Id",insertable = false, updatable = false)
    private User AddedBy;

    private Date CreatedDt;

    private Date ModifiedDt;

}
