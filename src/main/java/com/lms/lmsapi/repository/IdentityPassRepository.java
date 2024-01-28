package com.lms.lmsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.lms.lmsapi.entity.IdentityPass;
import com.lms.lmsapi.entity.User;

@Repository
public interface IdentityPassRepository extends JpaRepository<IdentityPass, Long>, JpaSpecificationExecutor<IdentityPass>
{
    //case matters for the entity attributes being mentioned in name of function
    IdentityPass findByUseridAndIsactive(User userid, Long isactive);
}
