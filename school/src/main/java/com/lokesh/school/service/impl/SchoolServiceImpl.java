package com.lokesh.school.service.impl;

import com.lokesh.school.client.StudentClient;
import com.lokesh.school.entity.FullSchoolResponse;
import com.lokesh.school.entity.School;
import com.lokesh.school.repository.SchoolRepository;
import com.lokesh.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public School saveSchool(School school) {
        return schoolRepository.save(school);

    }


    @Override
    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    /**
     * @param schoolId
     * @return
     */
    @Override
    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build()
                );
        var students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
