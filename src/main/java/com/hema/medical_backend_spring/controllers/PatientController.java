package com.hema.medical_backend_spring.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hema.medical_backend_spring.dto.UpdateBloodTypeDto;
import com.hema.medical_backend_spring.dto.UpdatePatientEmergencyDto;
import com.hema.medical_backend_spring.dto.UpdateUserPersonalDetailsDto;
import com.hema.medical_backend_spring.model.Patient;
import com.hema.medical_backend_spring.services.PatientService;
import com.hema.medical_backend_spring.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PatientController {
    private final UserService userService;
    private final PatientService patientService;

    @PostMapping("/user/update-personal-details")
    public String updatePatient(@ModelAttribute UpdateUserPersonalDetailsDto dto, Principal principal) {
        userService.updateUser(dto, principal.getName());
        return "redirect:/home";
    }

    @PostMapping("/patient/update-emergency-contact")
    public String updateEmergencyContact(@ModelAttribute UpdatePatientEmergencyDto dto, Principal principal) {
        patientService.updatePatientEmergency(dto, principal.getName());
        return "redirect:/home";
    }
    @PostMapping("/patient/update-blood-type")
    public String updateBloodType(@ModelAttribute UpdateBloodTypeDto dto, Principal principal) {
        patientService.updateBloodType(dto, principal.getName());
        return "redirect:/home";
    }


}
