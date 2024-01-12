package com.lms.lmsapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsapi.entity.Faculty;
import com.lms.lmsapi.exception.FacultyNotFoundException;
import com.lms.lmsapi.exception.FacultyRepository;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    
    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getFaculties()
    {
        return (List<Faculty>) facultyRepository.findAll();
    }

    @Override
    public Faculty createFaculty(Faculty faculty)
    {
        if (faculty != null) 
        {
            return facultyRepository.save(faculty);
            
        }
        else{
            throw new FacultyNotFoundException("Faculty object not created correctly.");
        }
    }

    @Override
    public Faculty getFaculty(int FacultyId)
    {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(FacultyId);

        if (optionalFaculty.isPresent()) 
        {
            return optionalFaculty.get();    
        } else {
            throw new FacultyNotFoundException("Facult was not found.");
        }
    }

    @Override
    public Faculty updateFaculty(Faculty faculty)
    {
        Faculty existingFaculty = facultyRepository.findById(faculty.getId()).get();

        existingFaculty.setFacultyname(faculty.getFacultyname());
        existingFaculty.setModifiedDt(faculty.getModifiedDt());

        Faculty updatedFaculty = facultyRepository.save(existingFaculty);

        return updatedFaculty;
        
    }

    @Override
    public void deleteFaculty(int facultyId)
    {
        facultyRepository.deleteById(facultyId);
    }
}
