package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot in Docker!";
    }

    @GetMapping("/hello")
    public String say_hello() {
        return "hello!";
    }
}