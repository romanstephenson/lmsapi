package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.Staff;

public interface StaffService 
{
    List<Staff> getStaffs();
    Staff getStaff(Long id);
    Staff createStaff(Staff staff);
    Staff updateStaff(Staff staff);
    void deleteStaff(Long staffId);    
}
