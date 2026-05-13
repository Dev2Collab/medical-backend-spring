package com.hema.medical_backend_spring.controllers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hema.medical_backend_spring.dto.ServiceDto;
import com.hema.medical_backend_spring.model.MedicalServiceEntity;
import com.hema.medical_backend_spring.services.MedicalServiceService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/services")
@AllArgsConstructor
public class ServicesController {
    private final MedicalServiceService medicalServiceService;

    @GetMapping("")
    public String getServicesPage(Authentication authentication, Model model,@RequestParam(required = false) String specialty,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size) {
        model.addAttribute("services", medicalServiceService.getServicesBySpecialty(specialty,page,size).getContent());
        if (authentication != null && authentication.isAuthenticated()
                && authentication.getAuthorities().toArray()[0].toString().equals("ADMIN")) {
            return "service/services";
        }
        return new String("services");
    }

    // TODO ADD THE SEARCH METHOD

    @GetMapping("/add-service")
    public String getAddServicePage(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()
                && authentication.getAuthorities().toArray()[0].toString().equals("ADMIN")) {
            return "service/add-service";
        }
        return new String("services");
    }

    @GetMapping("/edit/{id}")
    public String getEditServicePage(Authentication authentication, Model model, @PathVariable long id) {
        MedicalServiceEntity service = medicalServiceService.getServiceById(id);
        model.addAttribute("service", service);
        model.addAttribute("features", service.getFeatures());
        if (authentication != null && authentication.isAuthenticated()
                && authentication.getAuthorities().toArray()[0].toString().equals("ADMIN")) {
            return "service/edit-service";
        }
        return new String("services");
    }

    @PostMapping("/add-service")
    public String createService(@ModelAttribute ServiceDto dto, Principal principal,
            RedirectAttributes redirectAttributes) {
        medicalServiceService.createService(dto, principal.getName());
        redirectAttributes.addFlashAttribute("message", "تم انشاء الخدمه بنجاح .");
        return "redirect:/success";
    }

    @PostMapping("/edit-service/{id}")
    public String updateService(@ModelAttribute ServiceDto dto, Principal principal,
            RedirectAttributes redirectAttributes, @PathVariable long id) {
        medicalServiceService.updateService(id, dto);
        redirectAttributes.addFlashAttribute("message", "تم تحديث الخدمه بنجاح .");
        return "redirect:/success";
    }
    @PostMapping("/delete-service/{id}")
    public String deleteService(RedirectAttributes redirectAttributes, @PathVariable long id) {
        medicalServiceService.deleteService(id);
        redirectAttributes.addFlashAttribute("message", "تم حذف الخدمه بنجاح .");
        return "redirect:/success";
    }
    // TODO make the sections

}
