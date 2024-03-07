package com.lokesh.student.service;

import com.lokesh.student.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> findAllStudents();

    List<Student> findAllStudentsBySchool(Long schoolId);
}
