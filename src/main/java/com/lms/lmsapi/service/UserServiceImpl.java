package com.lms.lmsapi.service;

import com.lms.lmsapi.entity.User;
import com.lms.lmsapi.exception.UserNotFoundException;
//import com.lms.lmsapi.repository.EmailRepository;
import com.lms.lmsapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService 
{
    @Autowired
    private UserRepository userRepository;
    //private EmailRepository emailRepository;

    @Override
    public List<User> getUsers()
    {
        return ( List<User>) userRepository.findAll();
    }
    
    @Override
    public User getUserById(int id)
    {
        Optional<User> optionalUser = userRepository.findById(id);

        if( optionalUser.isPresent())
        {
            return optionalUser.get();
        }
        else
        {
            throw new UserNotFoundException("User Not Found");
        }
    }

    @Override
    public User createUser(User user)
    {
        if (user != null) 
        {
            return userRepository.save(user);    
        } else {
            throw new UserNotFoundException("User not found");
        }
        
    }

    @Override
    public User updateUser(User user)
    {
        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setMiddlename(user.getMiddlename());
        existingUser.setUsername(user.getUsername());
        existingUser.setDob(user.getDob());
        existingUser.setGender(user.getGender());
        existingUser.setEmail(user.getEmail());
        existingUser.setChangePass(user.getChangePass());
        existingUser.setIsActive(user.getIsActive());
        existingUser.setModifiedDt(user.getModifiedDt());

        User updatedUser = userRepository.save(existingUser);

        return updatedUser;
    }

    @Override
    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }
}
