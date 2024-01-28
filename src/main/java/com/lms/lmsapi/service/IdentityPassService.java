package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.IdentityPass;
import com.lms.lmsapi.entity.User;

public interface IdentityPassService 
{
    List<IdentityPass> getAllIdentityPass();
    IdentityPass getIdentityPassByUserId(Long identpassid);
    IdentityPass createIdentityPass(IdentityPass identpass);
    IdentityPass updatIdentityPass(IdentityPass identpass);
    IdentityPass findByUserIdAndIsActive(User userid, Long isactive);
    void deleteIdentityPass(Long identpassid);
}
