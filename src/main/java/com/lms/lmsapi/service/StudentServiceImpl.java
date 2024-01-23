package com.lms.lmsapi.service;

import com.lms.lmsapi.entity.Student;
import com.lms.lmsapi.exception.StudentNotFoundException;
import com.lms.lmsapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudents()
    {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id)
    {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent())
        {
            return optionalStudent.get();
        }
        else{
            throw new StudentNotFoundException("Student not found.");
        }
    }

    @Override
    public Student createStudent(Student student)
    {
        if(student != null)
        {
            return studentRepository.save(student);
        }
        else{
            throw new StudentNotFoundException("Student object not formatted correctly.");
        }
    }

    @Override
    public Student updateStudent(Student student)
    {
        Student existingStudent = studentRepository.findById(student.getId()).get();

        existingStudent.setUserid(student.getUserid());
        existingStudent.setCatid(student.getCatid());
        existingStudent.setFacultyid(student.getFacultyid());
        existingStudent.setYear(student.getYear());
        existingStudent.setCreatedDt(student.getCreatedDt());
        existingStudent.setModifiedDt(student.getModifiedDt());

        Student updatedStudent = studentRepository.save(existingStudent);

        return updatedStudent;

    }

    @Override
    public void deleteStudent(Long studentId)
    {
        studentRepository.deleteById(studentId);
    }
    
}
