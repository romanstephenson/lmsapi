package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"userid",
"emailAddress",
"isPrimary",
"createdDt",
"modifiedDt"
})
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Email")
public class Email implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailid;

    @ManyToOne
    @JsonProperty("userid")
	@JoinColumn (name="userid", updatable = false)
    private User userid;

    @Column(nullable = false)
    private String emailAddress; 

    @Column(nullable = false)
    private Long isPrimary;

    @Column(nullable = true)
    private Date createdDt;

    @Column(nullable = true)
    private Date modifiedDt;
}
