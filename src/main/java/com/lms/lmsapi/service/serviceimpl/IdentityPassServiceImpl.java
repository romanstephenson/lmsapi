package com.lms.lmsapi.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsapi.entity.IdentityPass;
import com.lms.lmsapi.entity.User;
import com.lms.lmsapi.exception.IdentityPassNotFoundException;
import com.lms.lmsapi.repository.IdentityPassRepository;
import com.lms.lmsapi.service.IdentityPassService;

@Service
public class IdentityPassServiceImpl implements IdentityPassService
{
    @Autowired
    private IdentityPassRepository identityPassRepository;

    @Override
    public List<IdentityPass> getAllIdentityPass()
    {
        return (List<IdentityPass>) identityPassRepository.findAll();
    }

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
    public IdentityPass getIdentityPassByUserId(Long id)
    {
        if(id == null)
        {
            throw new IdentityPassNotFoundException("User id can not be null.");
        }

        Optional <IdentityPass> optionalPass = identityPassRepository.findById(id);

        if (optionalPass.isPresent()) 
        {
            return optionalPass.get();    
        } else 
        {
            throw new IdentityPassNotFoundException("Identity Pass not found");    
        }
    }

    @Override
    public IdentityPass findByUserIdAndIsActive(User userid, Long isactive)
    {
        if(userid == null || isactive == null)
        {
            throw new IdentityPassNotFoundException("User id or isactive can not be null.");
        }

        IdentityPass Pass = identityPassRepository.findByUseridAndIsactive(userid,isactive);

        if (Pass != null) 
        {
            return Pass;    
        } else 
        {
            throw new IdentityPassNotFoundException("Identity Pass not found");    
        }
    }

    @Override
    public IdentityPass updatIdentityPass(IdentityPass identityPass)
    {
        if (identityPass.getIdentpassid() != null) 
        {
            IdentityPass existingIdentityPass = identityPassRepository.findById(identityPass.getIdentpassid().longValue()).get();

            existingIdentityPass.setPassword(identityPass.getPassword());
            existingIdentityPass.setIsactive(identityPass.getIsactive());
            existingIdentityPass.setUserid(identityPass.getUserid());
            existingIdentityPass.setValidtill(identityPass.getValidtill());
            existingIdentityPass.setCreatedDt(identityPass.getCreatedDt());
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
