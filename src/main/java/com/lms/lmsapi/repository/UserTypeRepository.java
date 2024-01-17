package com.lms.lmsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Integer>{
    
}
