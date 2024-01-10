package com.lms.lmsapi.repository;

import com.lms.lmsapi.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>
{
    
}
