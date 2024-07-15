package com.lms.lmsapi.service.serviceimpl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsapi.entity.IdentityPass;
import com.lms.lmsapi.entity.User;
import com.lms.lmsapi.exception.IdentityPassNotFoundException;
import com.lms.lmsapi.repository.IdentityPassRepository;
import com.lms.lmsapi.repository.UserRepository;
import com.lms.lmsapi.service.IdentityPassService;

@Service
public class IdentityPassServiceImpl implements IdentityPassService
{
    @Autowired
    private IdentityPassRepository identityPassRepository;
    @Autowired
    private UserRepository userRepository;

    // @Override
    // public List<IdentityPass> getAllIdentityPass()
    // {
    //     return (List<IdentityPass>) identityPassRepository.findAll();
    // }

    @Override
    public IdentityPass createIdentityPass(IdentityPass identityPass)
    {
        if(identityPass != null)
        {
            return identityPassRepository.save(identityPass);
        }
        else{
            throw new IdentityPassNotFoundException("Identity Pass object can not be null.");
        }
    }

    @Override
    public IdentityPass getIdentityPass(Long id)
    {
        if(id == null) 
        {
            throw new IdentityPassNotFoundException("User id can not be null.");
        }

        Optional<IdentityPass> optionalPass = identityPassRepository.findById(id);

        if (optionalPass.isPresent()) 
        {
            return optionalPass.get();    
        } else 
        {
            throw new IdentityPassNotFoundException("Identity Pass not found");    
        }
    }

    @Override
    public IdentityPass getIdentityPassActive(Long userid)
    {
        if(userid == null)
        {
            throw new IdentityPassNotFoundException("User id or isactive can not be null.");
        }

        Optional<User> user = userRepository.findById(userid);

        IdentityPass Pass = identityPassRepository.findByUseridAndIsActive(user.get(), 1);

        if (Pass != null) 
        {
            return Pass;    
        } else 
        {
            throw new IdentityPassNotFoundException("Identity Pass not found for user with ID: " + userid);    
        }
    }
    

    @Override
    public IdentityPass updatIdentityPass(IdentityPass identityPass)
    {
        if (!Objects.isNull(identityPass)) 
        {
            IdentityPass existingIdentityPass = identityPassRepository.findById(identityPass.getIdentpassid().longValue()).get();

            existingIdentityPass.setPassword(identityPass.getPassword());
            existingIdentityPass.setIsActive(identityPass.getIsActive());
            existingIdentityPass.setUserid(identityPass.getUserid());
            existingIdentityPass.setValidtill(identityPass.getValidtill());
            //existingIdentityPass.setCreatedDt(identityPass.getCreatedDt());
            existingIdentityPass.setModifiedDt(identityPass.getModifiedDt());

            IdentityPass updatedIdentityPass = identityPassRepository.save(existingIdentityPass);

            return updatedIdentityPass;
        }

        throw new IdentityPassNotFoundException("Identity object can not be null.");
    }


    @Override
    public void deleteIdentityPass(Long identid)
    {
        if (identid != null) {
            identityPassRepository.deleteById(identid);
        } else {
            throw new IdentityPassNotFoundException("Identity Pass not found");
        }
    }
    
}
