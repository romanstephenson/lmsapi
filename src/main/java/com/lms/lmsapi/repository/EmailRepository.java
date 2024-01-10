package com.lms.lmsapi.repository;

import com.lms.lmsapi.entity.Email;

import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<Email, Integer>{
    
}