package com.example.backend.domain.entity;

import com.example.backend.domain.entity.converters.CourseTypeConverter;
import com.example.backend.domain.entity.converters.ListOfStringConverter;
import com.example.backend.domain.entity.enums.CourseType;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity(name = "Course")
@Table(name = "course")
@Access(AccessType.FIELD)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "credit_hours")
    private Integer creditHours;

    @Column(name = "course_type")
    @Convert(converter = CourseTypeConverter.class)
    private CourseType courseType;

    @Column(name = "topics")
    @Convert(converter = ListOfStringConverter.class)
    private List<String> topics = new ArrayList<>();

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students;
}
