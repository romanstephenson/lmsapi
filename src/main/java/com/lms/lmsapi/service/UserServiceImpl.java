package com.lms.lmsapi.service;

import com.lms.lmsapi.entity.User;
import com.lms.lmsapi.exception.UserNotFoundException;
import com.lms.lmsapi.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
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
    public User getUserById(Long id)
    {
         if( id == null)
        {
            throw new UserNotFoundException("User Id can not be empty or null.");
        }

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
    public User createUser(User user )
    {
        
        if (user != null) 
        {
            return userRepository.save(user);            
        } 
        else {
            throw new UserNotFoundException("User not found");
        }
        
    }

    @Override
    public User updateUser(User user)
    {
        if( user.getUserid() != null)
        {
            User existingUser = userRepository.findById(user.getUserid().longValue()).get();

            existingUser.setFirstname(user.getFirstname());
            existingUser.setLastname(user.getLastname());
            existingUser.setMiddlename(user.getMiddlename());
            existingUser.setUsername(user.getUsername());
            existingUser.setDob(user.getDob());
            existingUser.setGender(user.getGender());
            existingUser.setChangePass(user.getChangePass());
            existingUser.setIsActive(user.getIsActive());
            existingUser.setModifiedDt(user.getModifiedDt());

            User updatedUser = userRepository.save(existingUser);

            return updatedUser;
        }

        throw new UserNotFoundException("User Id can not be empty or null.");
    }

    @Override
    public void deleteUser(Long id)
    {
        if(id != null)
        {
            userRepository.deleteById(id);
        }
    }
}
