package com.lms.lmsapi.repository;

import com.lms.lmsapi.entity.Email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>
{
    
}