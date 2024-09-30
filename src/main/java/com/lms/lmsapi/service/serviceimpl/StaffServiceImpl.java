package com.lms.lmsapi.service.serviceimpl;

import com.lms.lmsapi.entity.Staff;
import com.lms.lmsapi.repository.StaffRepository;
import com.lms.lmsapi.service.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService
{
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staff> getStaffs()
    {
        return (List<Staff>) staffRepository.findAll();
    }

    @Override
    public Staff getStaff(Long id)
    {
        Optional<Staff> optionalStaff = staffRepository.findById(id);

        // if(optionalStaff.isPresent())
        // {
            return optionalStaff.get();
        //}

    }

    @Override
    public Staff createStaff(Staff staff)
    {
        // if(staff != null)
        // {
            return staffRepository.save(staff);
        //}

    }

    @Override
    public Staff updateStaff(Staff staff)
    {
        Staff existingStaff = staffRepository.findById(staff.getId()).get();

        existingStaff.setUserid(staff.getUserid());
        existingStaff.setDepid(staff.getDepid());
        existingStaff.setHireStartDt(staff.getHireStartDt());
        existingStaff.setHireEndDt(staff.getHireEndDt());
        existingStaff.setModifiedDt(staff.getModifiedDt());

        Staff updatedStudent = staffRepository.save(existingStaff);

        return updatedStudent;

    }

    @Override
    public void deleteStaff(Long staffId)
    {
        staffRepository.deleteById(staffId);
    }
    
}
