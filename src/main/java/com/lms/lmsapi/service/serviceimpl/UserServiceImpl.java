package com.lms.lmsapi.service.serviceimpl;

import com.lms.lmsapi.entity.Email;
import com.lms.lmsapi.entity.IdentityPass;
import com.lms.lmsapi.entity.User;
import com.lms.lmsapi.entity.UserType;
import com.lms.lmsapi.entity.UserTypeMapping;
import com.lms.lmsapi.exception.UserNotFoundException;
import com.lms.lmsapi.repository.EmailRepository;
import com.lms.lmsapi.repository.IdentityPassRepository;
import com.lms.lmsapi.repository.UserRepository;
import com.lms.lmsapi.repository.UserTypeMappingRepository;
import com.lms.lmsapi.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{ 
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private UserTypeMappingRepository userTypeMappingRepository;
    @Autowired
    private IdentityPassRepository identityPassRepository;

    @Override
    public List<User> getUsers()
    {
        return ( List<User>) userRepository.findAll();
    }
    
    
    @Override
    public User getUserById(Long id)
    {
        // Optional<User> optionalUser = userRepository.findById(id);

        // return optionalUser.get();

        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id) );
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
    public User createFullUser(User user)
    {
        // System.out.println(user.toString());
        User newUser = new User();
        UserTypeMapping newUserTypeMapping = new UserTypeMapping();
        Email newEmail = new Email(); 
        UserType existingUserType = new UserType();
        IdentityPass identityPass = new IdentityPass();

        //create user only object
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setMiddlename(user.getMiddlename());
        newUser.setUsername(user.getUsername());
        newUser.setDob(user.getDob());
        newUser.setGender(user.getGender());
        newUser.setChangePass(user.getChangePass());
        newUser.setIsActive(user.getIsActive());
        newUser.setCreatedDt(user.getCreatedDt());
        newUser.setModifiedDt(user.getModifiedDt());

        //save user only object
        User savedUser = userRepository.save(newUser);

        //setup email object
        newEmail = user.getEmail().get(0);
        newEmail.setUserid(savedUser);

        //save email object
        emailRepository.save(newEmail);

        //retrieve existing user type with id passed in
        existingUserType = user.getUsertypemapping().get(0).getUsertypeid();
        System.out.println(existingUserType);
        existingUserType.getUsertypeid();

        //setup user type mapping object
        newUserTypeMapping.setUsertypeid(existingUserType);
        newUserTypeMapping.setUserid(savedUser);
        newUserTypeMapping.setCreatedDt(user.getUsertypemapping().get(0).getCreatedDt());
        newUserTypeMapping.setModifiedDt(user.getUsertypemapping().get(0).getModifiedDt());

        //save user type mapping object
        userTypeMappingRepository.save(newUserTypeMapping);

        //setup identity pass object
        identityPass.setUserid(savedUser);
        identityPass.setPassword(user.getPass().get(0).getPassword());
        identityPass.setIsactive(user.getPass().get(0).getIsactive());
        identityPass.setValidtill(user.getPass().get(0).getValidtill());
        identityPass.setCreatedDt(user.getPass().get(0).getCreatedDt());
        identityPass.setModifiedDt(user.getPass().get(0).getModifiedDt());

        //save identity pass object
        identityPassRepository.save(identityPass);

        Long userId = savedUser.getUserid().longValue();

        return userRepository.findById(userId).get();
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
