package com.lms.lmsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.Department;;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    
}
