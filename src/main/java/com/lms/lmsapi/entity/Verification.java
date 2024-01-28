package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"verificationstatus","verificationtoken","userid","createdDt","modifiedDt"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Verification")
public class Verification implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verid;

    private int verificationstatus;

    private String verificationtoken;

    @ManyToOne
    @JsonProperty("userid")
    /*added to allow bidirectional relationship, pass has a user, user has a pass
     * otherwise an infinite json recursion loop will occur and fail
     */
    @JsonBackReference
    @JoinColumn(name = "userid",insertable = true, updatable = false)
    private User userid;

    private Date createdDt;

    private Date verifiedDt;
    
}
