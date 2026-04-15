package com.hema.medical_backend_spring.controllers;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hema.medical_backend_spring.config.CustomUserDetails;
import com.hema.medical_backend_spring.model.Patient;
import com.hema.medical_backend_spring.services.PatientService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
   private final PatientService patientService;
    @GetMapping(path = { "/home", "/" })
    public String getHomePage(Authentication authentication, Model model) {


        if (authentication != null && authentication.isAuthenticated()) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            if (authentication.getAuthorities().toArray()[0].toString().equals("PATIENT")){
                Patient patient=patientService.getPatient(userDetails.getProjectUser().getId()).orElse(null);
            model.addAttribute("user", patient);
                return "profile/patient";
            }
            else if (authentication.getAuthorities().toArray()[0].toString().equals("DOCTOR"))
                return "profile/doctor";
            else if (authentication.getAuthorities().toArray()[0].toString().equals("ADMIN"))
                return "profile/admin";

            return "/home";
        }
        return new String("home");
    }

}
