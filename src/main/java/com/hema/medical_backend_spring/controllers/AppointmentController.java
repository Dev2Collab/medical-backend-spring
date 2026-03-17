package com.hema.medical_backend_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/book-appointment")
public class AppointmentController {

    @GetMapping()
    public String getMethodName() {
        return new String("appointment");
    }
    
}
