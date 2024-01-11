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
    private int Id;

    @ManyToOne
    @JoinColumn (name="BookId")
    private Book book;

    @ManyToOne
    @JoinColumn (name="StudentId")
    private Student IssuedTo;

    @ManyToOne
    @JoinColumn(name = "StaffId")
    private Staff IssuedBy;

    private Date IssueDt;

    private Date ReturnDt;

    private Date ModifiedDt;
}
