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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"userid","emailAddress","isPrimary","createdDt","modifiedDt"})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Email")
public class Email implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("emailid")
    private Long emailid;

    @ManyToOne
    @JsonProperty("userid")
    /* needed for bidirectional relationship. otherwise a coult not write json infinite recursion overflow will take please.
     * it happens because email has reference to user and user has reference to email which then causes an infinite json recursion
     */
    @JsonBackReference  
	@JoinColumn (name="userid", updatable = false)
    private User userid;

    @Column(nullable = false)
    private String emailAddress; 

    @Column(nullable = false)
    private Long isPrimary;

    @Column(nullable = false)
    private Date createdDt;

    @Column(nullable = false)
    private Date modifiedDt;
}
