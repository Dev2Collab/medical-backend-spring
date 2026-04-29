package com.hema.medical_backend_spring.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping( "/services")
public class ServicesController {
    @GetMapping("")
    public String getServicesPage(Authentication authentication, Model model) {
                if (authentication != null && authentication.isAuthenticated() && authentication.getAuthorities().toArray()[0].toString().equals("ADMIN")) {
            return "service/services";
        }
        return new String("services");
    }
    
}
