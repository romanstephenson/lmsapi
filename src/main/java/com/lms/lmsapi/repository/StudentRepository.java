package com.lms.lmsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
