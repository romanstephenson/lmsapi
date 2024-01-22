package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.StudentCategory;

public interface StudentCategoryService 
{
    List<StudentCategory> getStudentCategories();
    StudentCategory getStudentCategory(Long id);
    StudentCategory createStudentCategory(StudentCategory studentCategory);
    StudentCategory updateUserType(StudentCategory studentCategory);
    void deleteStudentCategory(Long categoryId);
} 
