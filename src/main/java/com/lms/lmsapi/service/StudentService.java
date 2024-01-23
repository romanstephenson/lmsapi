package com.lms.lmsapi.service;

import java.util.List;

import com.lms.lmsapi.entity.Student;

public interface StudentService 
{
     List<Student> getStudents();
     Student getStudent(Long id);
     Student createStudent(Student student);
     Student updateStudent(Student student);
     void deleteStudent(Long studentId);
}
