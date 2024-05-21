package com.school.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }
}