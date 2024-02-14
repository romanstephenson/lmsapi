package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.User;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long id);
    User createUser(User user);
    User createFullUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
}
 