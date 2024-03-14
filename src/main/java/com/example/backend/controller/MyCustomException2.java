package com.example.backend.controller;

public class MyCustomException2 extends RuntimeException {

    public MyCustomException2(String message) {
        super("MyCustomException2 message");
    }
}
