package com.lms.lmsapi.service.serviceimpl;

import com.lms.lmsapi.entity.Department;
import com.lms.lmsapi.repository.DepartmentRepository;
import com.lms.lmsapi.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments()
    {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long id)
    {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);

        //if( optionalDepartment.isPresent())
        //{
            return optionalDepartment.get();
        //}
    }

    @Override
    public Department createDepartment(Department department)
    {
        //if (department != null) {
            return departmentRepository.save(department);
        //}
    }

    @Override
    public Department updateDepartment(Department department)
    {
        Department existingDepartment = departmentRepository.findById(department.getDepid()).get();

        existingDepartment.setDepartmentname(department.getDepartmentname() );
        existingDepartment.setFacultyid(department.getFacultyid());
        existingDepartment.setModifiedDt(department.getModifiedDt() );

        Department updatedDepartment = departmentRepository.save(existingDepartment);

        return updatedDepartment;
    }

    @Override
    public void deleteDepartment(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }
    
}
