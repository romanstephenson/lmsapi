package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "Book_Category")
public class BookCategory implements Serializable
{
    
    @Id
    @JsonProperty("bookcatid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookcatid;

    @Column(nullable = false)
    private String category;

    @Column(nullable = true)
    private Date createdDt;

    @Column(nullable = true)
    private Date modifiedDt;

}
