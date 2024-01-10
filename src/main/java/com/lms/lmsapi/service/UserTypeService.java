package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.UserType;

public interface UserTypeService 
{
    List<UserType> getUserTypes();
    UserType getUserType(int id);
    UserType createUserType(UserType userType);
    UserType updateUserType(UserType userType);
    void deleteUserType(int userTypeId);
}