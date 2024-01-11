package com.lms.lmsapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.UserType;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Integer>{
    
}
