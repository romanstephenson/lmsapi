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
@Table(name = "Staff")

public class Staff {
    
    //@OneToOne(mappedBy = "User")
    @Id
    @OneToOne
	@JoinColumn (name="Id",insertable = false, updatable = false)
    private User StaffId;

    private String department;

    private Date hireStartDt;

    private Date hireEndDt;

    private Date createdDt;

    private Date modifiedDt;
}
