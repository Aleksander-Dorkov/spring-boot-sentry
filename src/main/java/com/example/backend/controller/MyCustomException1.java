package com.example.backend.controller;

public class MyCustomException1 extends RuntimeException {

    public MyCustomException1(String message) {
        super("MyCustomException message");
    }
}
