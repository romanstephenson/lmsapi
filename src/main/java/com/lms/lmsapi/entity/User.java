package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("userid")
    private Long userid;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String middlename;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private int changePass;

    @Column(nullable = false)
    private int isActive;

    /* 
        @JsonManagedReference
        needed for bidirectional relationship. otherwise a coult not write json infinite recursion overflow will take please.
     * it happens because email has reference to user and user has reference to email which then causes an infinite json recursion
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "userid", fetch = FetchType.EAGER)
    List<Email> emails = new ArrayList<Email>();

    /* 
        @JsonManagedReference
        needed for bidirectional relationship. otherwise a coult not write json infinite recursion overflow will take please.
     * it happens because email has reference to user and user has reference to email which then causes an infinite json recursion
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "userid", fetch = FetchType.EAGER)
    List<UserTypeMapping> usertype = new ArrayList<UserTypeMapping>();

    /* 
        @JsonManagedReference
        needed for bidirectional relationship. otherwise a coult not write json infinite recursion overflow will take please.
     * it happens because email has reference to user and user has reference to email which then causes an infinite json recursion
     */ 
    @JsonManagedReference
    @OneToMany(mappedBy = "userid", fetch = FetchType.EAGER)
    List<IdentityPass> pass = new ArrayList<IdentityPass>();

    @Column(nullable = true)
    private Date createdDt; 

    @Column(nullable = true)
    private Date modifiedDt;

}
