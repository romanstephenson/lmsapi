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
@Table(name = "Book_Issue_Log")
public class BookIssueLog 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name="BookId",insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn (name="StudentId",insertable = false, updatable = false)
    private Student issuedTo;

    @ManyToOne
    @JoinColumn(name = "StaffId",insertable = false, updatable = false)
    private Staff issuedBy;

    private Date issueDt;

    private Date returnDt;

    private Date modifiedDt;
}
