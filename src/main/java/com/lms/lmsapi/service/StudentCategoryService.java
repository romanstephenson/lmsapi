package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.StudentCategory;

public interface StudentCategoryService 
{
    List<StudentCategory> getStudentCategories();
    StudentCategory getStudentCategory(int id);
    StudentCategory createStudentCategory(StudentCategory studentCategory);
    StudentCategory updateUserType(StudentCategory studentCategory);
    void deleteStudentCategory(int categoryId);
} 
