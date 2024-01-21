package com.lms.lmsapi.service;

import com.lms.lmsapi.entity.UserType;
import com.lms.lmsapi.exception.UserTypeNotFoundException;
import com.lms.lmsapi.repository.UserTypeRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserTypeServiceImpl implements UserTypeService
{
    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> getUserTypes()
    {
        return (List<UserType>) userTypeRepository.findAll();
    }

    @Override
    public UserType getUserType(int id)
    {
        Optional<UserType> optionalUserType = userTypeRepository.findById(id);

        if( optionalUserType.isPresent())
        {
            return optionalUserType.get();
        }
        else
        {
            throw new UserTypeNotFoundException("UserType Not Found with id: " + id);
        }
    }

    @Override
    public UserType createUserType(UserType userType)
    {
        if (userType != null) {
            return userTypeRepository.save(userType);
        }
        else
        {
            throw new UserTypeNotFoundException("UserType not formatted correctly");
        }
    }

    @Override
    public UserType updateUserType(UserType userType)
    {
        UserType existingUserType = userTypeRepository.findById(userType.getId()).get();

        existingUserType.setName(userType.getName());
        existingUserType.setStatus(userType.getStatus());
        existingUserType.setDescription(userType.getDescription());
        existingUserType.setCreatedDt(userType.getCreatedDt());
        existingUserType.setModifiedDt(userType.getModifiedDt());

        UserType updatedUserType = userTypeRepository.save(existingUserType);

        return updatedUserType;
    }

    @Override
    public void deleteUserType(int userTypeId)
    {
        userTypeRepository.deleteById(userTypeId);
    }
    
}
