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
@JsonPropertyOrder({"password","isactive","userid","validtill","createdDt","modifiedDt"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "identitypass")
public class IdentityPass implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identpassid;

    private String password;

    private int isactive;

    @ManyToOne 
    @JsonProperty("userid")
    /* needed for bidirectional relationship. otherwise a coult not write json infinite recursion overflow will take please.
     * it happens because email has reference to user and user has reference to email which then causes an infinite json recursion
     */
    @JsonBackReference
    @JoinColumn(name = "userid",insertable = true, updatable = false)
    private User userid;

    private Long validtill;

    private Date createdDt;

    private Date modifiedDt;
    
}
