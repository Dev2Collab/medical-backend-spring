package com.hema.medical_backend_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class DoctorsController {
    
    @GetMapping("/doctors")
    public String getMethodName() {
        return new String("doctors");
    }
    

}
