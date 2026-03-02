package com.hema.medical_backend_spring.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WelcomController {
    @GetMapping("/welcome")
    public String greeting() {
        return new String("welcome to our new project.");
    }

}
