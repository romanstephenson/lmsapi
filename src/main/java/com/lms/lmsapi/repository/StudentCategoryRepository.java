package com.lms.lmsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.StudentCategory;

@Repository
public interface StudentCategoryRepository extends JpaRepository<StudentCategory, Integer>{
    
}
