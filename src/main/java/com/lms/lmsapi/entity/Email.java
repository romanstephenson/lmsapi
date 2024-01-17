package com.lms.lmsapi.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Email")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonProperty("user")
	@JoinColumn (name="id",insertable = false, updatable = false)
    private User user;

    private String emailAddress; 

    private int isPrimary;

    private Date createdDt;

    private Date modifiedDt;
}
