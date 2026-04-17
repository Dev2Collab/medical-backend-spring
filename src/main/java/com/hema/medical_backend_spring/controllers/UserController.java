package com.hema.medical_backend_spring.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hema.medical_backend_spring.dto.UpdatePasswordDto;
import com.hema.medical_backend_spring.dto.UpdateUserPersonalDetailsDto;
import com.hema.medical_backend_spring.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/users") 
public class UserController {
    private final UserService userService;

    @PostMapping("/update-personal-details")
    public String updatePatient(@ModelAttribute UpdateUserPersonalDetailsDto dto, Principal principal) {
        userService.updateUser(dto, principal.getName());
        return "redirect:/home";
    }
 @PostMapping("/update-password")
public String updatePassword(@ModelAttribute UpdatePasswordDto dto, Principal principal,RedirectAttributes redirectAttributes) {
    userService.updatePassword(dto, principal.getName());
    redirectAttributes.addFlashAttribute("successMessage","تم تغير الرقم السري بنجاح ");
    return "redirect:/success";
}

}
