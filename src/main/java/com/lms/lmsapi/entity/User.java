package com.lms.lmsapi.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"firstname","middlename","lastname","username","dob","gender","changePass","isActive","email","usertypemapping","pass","createdDt","modifiedDt"})
@Entity
@Getter
@Setter
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
    private List<Email> email = new ArrayList<Email>();
    //private Email email;

    /* 
        @JsonManagedReference
        needed for bidirectional relationship. otherwise a coult not write json infinite recursion overflow will take please.
     * it happens because email has reference to user and user has reference to email which then causes an infinite json recursion
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "userid", fetch = FetchType.EAGER)
    private List<UserTypeMapping> usertypemapping = new ArrayList<UserTypeMapping>();
    //private UserTypeMapping usertypemapping;

    /* 
        @JsonManagedReference
        needed for bidirectional relationship. otherwise a coult not write json infinite recursion overflow will take please.
     * it happens because email has reference to user and user has reference to email which then causes an infinite json recursion
     */ 
    @JsonManagedReference
    @OneToMany(mappedBy = "userid", fetch = FetchType.EAGER)
    private List<IdentityPass> pass = new ArrayList<IdentityPass>();
    //private IdentityPass pass;

    @Column(nullable = false)
    private Date createdDt; 

    @Column(nullable = false)
    private Date modifiedDt;

}
