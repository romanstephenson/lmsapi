package com.lms.lmsapi.service;

import com.lms.lmsapi.entity.StudentCategory;
import com.lms.lmsapi.exception.StudentCategoryNotFoundException;
import com.lms.lmsapi.exception.UserTypeNotFoundException;
import com.lms.lmsapi.repository.StudentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCategoryServiceImpl implements StudentCategoryService
{
    @Autowired
    private StudentCategoryRepository studentCategoryRepository;

    @Override
    public List<StudentCategory> getStudentCategories()
    {
        return (List<StudentCategory>) studentCategoryRepository.findAll();
    }

    @Override
    public StudentCategory getStudentCategory(int id)
    {
        Optional<StudentCategory> optionalStudentCategory = studentCategoryRepository.findById(id);

        if( optionalStudentCategory.isPresent())
        {
            return optionalStudentCategory.get();
        }
        else
        {
            throw new StudentCategoryNotFoundException("Student Category Not Found");
        }
    }

    @Override
    public StudentCategory createStudentCategory(StudentCategory studentCategory)
    {
        if (studentCategory != null) {
            return studentCategoryRepository.save(studentCategory);
        }
        else
        {
            throw new UserTypeNotFoundException("UserType not formatted correctly");
        }
    }

    @Override
    public StudentCategory updateUserType(StudentCategory studentCategory)
    {
        StudentCategory existingStudentCategory = studentCategoryRepository.findById(studentCategory.getCatId()).get();

        existingStudentCategory.setCategory(studentCategory.getCategory() );
        existingStudentCategory.setMaxAllowed(studentCategory.getMaxAllowed() );
        existingStudentCategory.setCreatedDt(studentCategory.getCreatedDt() );
        existingStudentCategory.setModifiedDt(studentCategory.getModifiedDt() );

        StudentCategory updatedStudentCategory = studentCategoryRepository.save(existingStudentCategory);

        return updatedStudentCategory;
    }

    @Override
    public void deleteStudentCategory(int studentCategoryId)
    {
        studentCategoryRepository.deleteById(studentCategoryId);
    }
    
}
