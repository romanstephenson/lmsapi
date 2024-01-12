package com.lms.lmsapi.exception;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.Faculty;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
    
}
