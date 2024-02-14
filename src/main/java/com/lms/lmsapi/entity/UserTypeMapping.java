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
@JsonPropertyOrder({"userid","usertypeid","createdDt","modifiedDt"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Type_Mapping")
public class UserTypeMapping  implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("usertypemappingid")
    private Long usertypemappingid;

    @OneToOne
    @JsonProperty("userid")
    /* needed for bidirectional relationship. otherwise a coult not write json infinite recursion overflow will take please.
     * it happens because email has reference to user and user has reference to email which then causes an infinite json recursion
     */
    @JsonBackReference  
    @JoinColumn(name="userid")
    private User userid;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonProperty("usertypeid")
    @JoinColumn(name="usertypeid")
    private UserType usertypeid;

    @Column(nullable = false)
    private Date createdDt;

    @Column(nullable = false)
    private Date modifiedDt;
}
