package com.lokesh.school.client;

import com.lokesh.school.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "students", url = "http://localhost:8080/api/v1/students")
public interface StudentClient {

    @GetMapping("/school/{school-id}")
    List<Student> findAllStudentsBySchool(@PathVariable("school-id") Long schoolId);
}
