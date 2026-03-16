package com.hema.medical_backend_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping( "/services")
public class ServicesController {
    @GetMapping("")
    public String getServicesPage() {
        return new String("services");
    }
    
}
