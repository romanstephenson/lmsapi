package com.lms.lmsapi.repository;

import com.lms.lmsapi.entity.Email;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<Email, Integer>{
    
}