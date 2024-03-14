package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.example.backend.controller.test")
public class Api2Advice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNullPointerException(Exception ex) {
        return ResponseEntity.ok(null);
    }
}
