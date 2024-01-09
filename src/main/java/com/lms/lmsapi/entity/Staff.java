package com.lms.lmsapi.entity;

import java.sql.Date;

import javax.persistence.*;
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
    @Id
    @OneToOne(mappedBy = "User")
	@JoinColumn (name="Id")
    private User StaffId;

    private String Department;

    private Date HireStartDt;

    private Date HireEndDt;

    private Date CreatedDt;

    private Date ModifiedDt;
}
