package com.example.backend;

import com.example.backend.domain.entity.Course;
import com.example.backend.domain.repository.CourseRepository;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class BackendApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void contextLoads() {
        List<Course> all = courseRepository.findAll();
        Assertions.assertThat(all).hasSize(8);
    }
}
