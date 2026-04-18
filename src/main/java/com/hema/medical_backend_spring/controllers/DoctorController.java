package com.hema.medical_backend_spring.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hema.medical_backend_spring.dto.CertificationDto;
import com.hema.medical_backend_spring.services.DoctorService;

import lombok.AllArgsConstructor;


@Controller
@RequestMapping("/doctor")
@AllArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    
    @GetMapping("/add-certification")
    public String getAddCertificationPage() {
        return new String("add-certification");
    }
    @PostMapping("/add-certification")
    public String addCertification(@ModelAttribute CertificationDto certification,Authentication authentication,RedirectAttributes redirectAttributes) {
        doctorService.addCertification(certification ,authentication);
        redirectAttributes.addFlashAttribute("successMessage","تم اضافة الشهاده بنجاح");
        return "redirect:/success";
    }
    

}
