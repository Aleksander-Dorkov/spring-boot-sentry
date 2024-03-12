package com.example.backend.domain.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CourseType {
    MANDATORY("Mandatory Course"), OPTIONAL("Optional Course");
    private final String courseType;

    public static CourseType findByCourseType(String courseType) {
        return Arrays.stream(values())
                .filter(enumValue -> enumValue.courseType.equals(courseType))
                .findFirst()
                .orElse(null); // Return null if not found
    }
}
