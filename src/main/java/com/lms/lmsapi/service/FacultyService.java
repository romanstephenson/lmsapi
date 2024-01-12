package com.lms.lmsapi.service;

import com.lms.lmsapi.entity.Faculty;

import java.util.List;

public interface FacultyService {
    
    List<Faculty> getFaculties();
    Faculty getFaculty(int Id);
    Faculty createFaculty(Faculty faculty);
    Faculty updateFaculty(Faculty faculty);
    void deleteFaculty(int FacultyId);
}
