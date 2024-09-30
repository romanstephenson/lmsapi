package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.Department;

public interface DepartmentService 
{
    List<Department> getDepartments();
    Department getDepartment(Long id);
    Department createDepartment(Department department);
    Department updateDepartment(Department department);
    void deleteDepartment(Long departmentId);
}
