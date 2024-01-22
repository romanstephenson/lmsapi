package com.lms.lmsapi.service;
import com.lms.lmsapi.entity.UserType;

import java.util.List;

public interface UserTypeService 
{
    List<UserType> getUserTypes();
    UserType getUserType(Long id);
    UserType createUserType(UserType userType);
    UserType updateUserType(UserType userType);
    void deleteUserType(Long userTypeId);
}