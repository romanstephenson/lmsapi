package com.lms.lmsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.StudentCategory;

@Repository
public interface StudentCategoryRepository extends CrudRepository<StudentCategory, Integer>{
    
}
