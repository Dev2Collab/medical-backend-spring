package com.hema.medical_backend_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {
    @GetMapping("/login")
    public String getLoginPage() {
        return new String("auth/login");
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return new String("auth/signup");
    }
    
    
}
