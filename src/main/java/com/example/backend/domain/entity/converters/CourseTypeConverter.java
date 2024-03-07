package com.example.backend.domain.entity.converters;

import com.example.backend.domain.entity.CourseType;
import jakarta.persistence.AttributeConverter;

public class CourseTypeConverter implements AttributeConverter<CourseType, String> {

    @Override
    public String convertToDatabaseColumn(CourseType attribute) {
        return attribute == null ? null : attribute.courseType();
    }

    @Override
    public CourseType convertToEntityAttribute(String dbData) {
        return dbData == null ? null : CourseType.findByCourseType(dbData);
    }
}
