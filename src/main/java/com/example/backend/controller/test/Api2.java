package com.example.backend.controller.test;

import com.example.backend.controller.MyCustomException1;
import com.example.backend.controller.MyCustomException2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2-with-advice")
public class Api2 {

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

}
