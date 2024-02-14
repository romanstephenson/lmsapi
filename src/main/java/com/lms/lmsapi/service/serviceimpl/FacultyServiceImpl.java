package com.lms.lmsapi.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsapi.entity.Faculty;
import com.lms.lmsapi.exception.FacultyNotFoundException;
import com.lms.lmsapi.repository.FacultyRepository;
import com.lms.lmsapi.service.FacultyService;

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
    public Faculty createFaculty( Faculty faculty)
    {
        return facultyRepository.save(faculty);
            
    }

    @Override
    public Faculty getFaculty(Long FacultyId)
    {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(FacultyId);

        if (optionalFaculty.isPresent()) 
        {
            return optionalFaculty.get();    
        } else {
            throw new FacultyNotFoundException("Faculty with ID: " + FacultyId + " was not found.");
        }
    }

    @Override
    public Faculty updateFaculty(Faculty faculty)
    {
        Faculty existingFaculty = facultyRepository.findById(faculty.getFacultyid().longValue()).get();

        existingFaculty.setFacultyname(faculty.getFacultyname());
        existingFaculty.setModifiedDt(faculty.getModifiedDt());

        Faculty updatedFaculty = facultyRepository.save(existingFaculty);

        return updatedFaculty;
        
    }

    @Override
    public void deleteFaculty(Long facultyId)
    {
        facultyRepository.deleteById(facultyId);
    }
}
