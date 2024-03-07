package com.lokesh.school.service;

import com.lokesh.school.entity.FullSchoolResponse;
import com.lokesh.school.entity.School;

import java.util.List;

public interface SchoolService {
    School saveSchool(School school);

    List<School> findAllSchools();

    FullSchoolResponse findSchoolsWithStudents(Long schoolId);
}
