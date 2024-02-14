package com.lms.lmsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.UserTypeMapping;

@Repository
public interface UserTypeMappingRepository extends JpaRepository<UserTypeMapping, Long> 
{
    
}
