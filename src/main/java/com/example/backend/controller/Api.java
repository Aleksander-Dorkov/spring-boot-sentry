package com.example.backend.controller;

import com.example.backend.controller.dto.CourseRequest;
import com.example.backend.controller.dto.StudentCourseRequest;
import com.example.backend.controller.dto.StudentRequest;
import com.example.backend.domain.entity.Course;
import com.example.backend.domain.entity.Student;
import com.example.backend.domain.repository.CourseRepository;
import com.example.backend.domain.repository.StudentRepository;
import io.sentry.Sentry;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/sentry/test/{exceptionValue}")
    public ResponseEntity<Void> testSentryExceptions(@PathVariable int exceptionValue) {
        try {
            var a = "my-specific-message-to-find-later-more-easy-on-sentry";
            switch (exceptionValue) {
                case 1 -> throw new RuntimeException(a);
                case 2 -> throw new NullPointerException(a);
                case 3 -> throw new IllegalArgumentException(a);
                case 4 -> throw new MyCustomException1(a);
                case 5 -> throw new MyCustomException2(a);
                default -> throw new RuntimeException(a);
            }
        } catch (Exception e) {
            throw e;
        }
    }


    @GetMapping("/sentry/test/with-try-catch-no-throw/{exceptionValue}")
    public ResponseEntity<Void> testSentryExceptions2(@PathVariable int exceptionValue) {
        try {
            var a = "my-specific-message-to-find-later-more-easy-on-sentry";
            switch (exceptionValue) {
                case 1 -> throw new RuntimeException(a);
                case 2 -> throw new NullPointerException(a);
                case 3 -> throw new IllegalArgumentException(a);
                case 4 -> throw new MyCustomException1(a);
                case 5 -> throw new MyCustomException2(a);
                default -> throw new RuntimeException(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.ok(null);
    }

    @PostMapping("/student")
    public StudentRequest insert(@RequestBody StudentRequest studentRequest) {
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            Sentry.captureException(e);
        }
        Student student = toStudent(studentRequest);
        Student save = this.studentRepository.save(student);
        return null;
    }

    @PostMapping("/course")
    public StudentRequest insert2(@RequestBody CourseRequest courseRequest) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            Sentry.captureException(e);
        }
        return null;
    }

    @PutMapping("student-course")
    public void addStudentToCourse(@RequestBody StudentCourseRequest request) {
        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            Sentry.captureException(e);
        }
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
