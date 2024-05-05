package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"bookid","issuedto","issuedby","issueDt","returnDt","modifiedDt"})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book_Issue_Log")
public class BookIssueLog implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookissueid;
 
    @OneToOne
    @JsonProperty("bookid")
    @JoinColumn (name="bookid",insertable = false, updatable = false)
    private Book bookid;

    @OneToOne
    @JsonProperty("issuedto")
    @JoinColumn (name="userid",insertable = false, updatable = false)
    private Student issuedto;
    //private User issuedto;

    @OneToOne
    @JsonProperty("issuedby")
    @JoinColumn(name = "userid",insertable = false, updatable = false)
    private Staff issuedby;
    //private User issuedby;

    @Column(nullable = false)
    private Date issueDt;

    @Column(nullable = false)
    private Date returnDt;

    @Column(nullable = false)
    private Date modifiedDt;
}
