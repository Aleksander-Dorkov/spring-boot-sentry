package com.example.backend.controller;

import com.example.backend.controller.dto.CourseRequest;
import com.example.backend.controller.dto.StudentCourseRequest;
import com.example.backend.controller.dto.StudentRequest;
import com.example.backend.domain.entity.Course;
import com.example.backend.domain.entity.Student;
import com.example.backend.domain.repository.CourseRepository;
import com.example.backend.domain.repository.StudentRepository;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Api {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final EntityManagerFactory emFactory;

    @PostMapping("/student")
    public StudentRequest insert(@RequestBody StudentRequest studentRequest) {
        Student student = toStudent(studentRequest);
        Student save = this.studentRepository.save(student);
        return null;
    }


    @PostMapping("/course")
    public StudentRequest insert2(@RequestBody CourseRequest courseRequest) {
        return null;
    }

    @PutMapping("student-course")
    public void addStudentToCourse(@RequestBody StudentCourseRequest request) {
        Student student = this.studentRepository.findOneWithCourses(request.studentId());
        Course course = this.courseRepository.getReferenceById(request.courseId());
        student.addNewCourses(List.of(course));
        this.studentRepository.save(student);
    }

    private Student toStudent(StudentRequest request) {
        return new Student()
                .email(request.email())
                .firstName(request.firstName())
                .lastName(request.lastName());
    }
}
