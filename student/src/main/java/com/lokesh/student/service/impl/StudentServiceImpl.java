package com.lokesh.student.service.impl;

import com.lokesh.student.entity.Student;
import com.lokesh.student.repository.StudentRepository;
import com.lokesh.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
