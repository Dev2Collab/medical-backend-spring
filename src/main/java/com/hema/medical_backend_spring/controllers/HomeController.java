package com.hema.medical_backend_spring.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hema.medical_backend_spring.config.CustomUserDetails;

@Controller
public class HomeController {
    @GetMapping(path = { "/home", "/" })
    public String getHomePage(Authentication authentication, Model model) {

        if (authentication != null && authentication.isAuthenticated()) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getProjectUser());
            if (authentication.getAuthorities().toArray()[0].toString().equals("PATIENT"))
                return "profile/patient";
            else if (authentication.getAuthorities().toArray()[0].toString().equals("DOCTOR"))
                return "profile/doctor";
            else if (authentication.getAuthorities().toArray()[0].toString().equals("ADMIN"))
                return "profile/admin";

            return "/home";
        }
        return new String("home");
    }

}
