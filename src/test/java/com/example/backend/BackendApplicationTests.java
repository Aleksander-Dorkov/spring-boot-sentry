package com.example.backend;

import com.example.backend.domain.entity.Course;
import com.example.backend.domain.repository.CourseRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BackendApplicationTests {

    @Autowired
    private CourseRepository courseRepository;


    @BeforeEach
    void setUp() {
        System.out.println("before each");
    }

    @BeforeAll
    void beforeAll() {
        System.out.println("beforeAll");
    }

    @Test
    void contextLoads1() {
        List<Course> all = courseRepository.findAll();
        Assertions.assertThat(all).hasSize(8);
    }

    @Test
    void contextLoads2() {
        List<Course> all = courseRepository.findAll();
        Assertions.assertThat(all).hasSize(8);
    }

    @Test
    void contextLoads3() {
        List<Course> all = courseRepository.findAll();
        Assertions.assertThat(all).hasSize(8);
    }
}
