package com.hema.medical_backend_spring.controllers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hema.medical_backend_spring.dto.ServiceDto;
import com.hema.medical_backend_spring.services.MedicalServiceService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/services")
@AllArgsConstructor
public class ServicesController {
    private final MedicalServiceService medicalServiceService;

    @GetMapping("")
    public String getServicesPage(Authentication authentication, Model model) {
        model.addAttribute("services", medicalServiceService.getAllServices());
        medicalServiceService.getAllServices().forEach(s-> s.getConsulating());
        if (authentication != null && authentication.isAuthenticated()
                && authentication.getAuthorities().toArray()[0].toString().equals("ADMIN")) {
            return "service/services";
        }
        return new String("services");
    }

    @GetMapping("/add-service")
    public String getAddServicePage(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()
                && authentication.getAuthorities().toArray()[0].toString().equals("ADMIN")) {
            return "service/add-service";
        }
        return new String("services");
    }

    @PostMapping("/add-service")
    public String createService(@ModelAttribute ServiceDto dto, Principal principal, RedirectAttributes redirectAttributes) {  
        medicalServiceService.createService(dto, principal.getName());
        redirectAttributes.addFlashAttribute("message", "تم انشاء الخدمه بنجاح .");
        return "redirect:/success";
    }

}
