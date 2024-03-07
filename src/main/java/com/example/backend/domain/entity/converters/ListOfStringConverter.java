package com.example.backend.domain.entity.converters;

import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class ListOfStringConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return String.join(",", list);
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        }
        return Arrays.asList(string.split(","));
    }
}
