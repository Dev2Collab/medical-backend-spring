package com.hema.medical_backend_spring.controllers;

import java.net.Authenticator;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    @GetMapping(path = {"/home","/"})
    public String getHomePage(Authentication authentication) {
         if (authentication != null && authentication.isAuthenticated()) {
            if(authentication.getAuthorities().toArray()[0].toString().equals("PATIENT"))
                return "dashboard/patient";
            else if(authentication.getAuthorities().toArray()[0].toString().equals("DOCTOR"))
                return "dashboard/doctor";
            else if(authentication.getAuthorities().toArray()[0].toString().equals("ADMIN"))
                return "dashboard/admin";

            return "/home";
        }
        return new String("home");
    }
    
    
    
}
