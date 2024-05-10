package com.lms.lmsapi.service;
import com.lms.lmsapi.entity.IdentityPass;

public interface IdentityPassService 
{
    //List<IdentityPass> getAllIdentityPass();
    IdentityPass getIdentityPass(Long identpassid);
    IdentityPass createIdentityPass(IdentityPass identpass);
    IdentityPass updatIdentityPass(IdentityPass identpass);
    IdentityPass getIdentityPassActive(Long userid);
    void deleteIdentityPass(Long identpassid);
}
