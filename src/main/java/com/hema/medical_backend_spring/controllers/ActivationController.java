package com.hema.medical_backend_spring.controllers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hema.medical_backend_spring.services.UserService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ActivationController {
    private final UserService userService;

    @GetMapping("/activate")
    public String activatePage(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }
        String email = principal.getName();
        System.out.println(userService.findByEmail(email).get().isActive());
        if (userService.findByEmail(email).get().isActive()) {
            return "redirect:/home";
        }
        model.addAttribute("email", email);
        return "activate";
    }

    @PostMapping("/activate/send")
    public String sendPin(@RequestParam String email) {
        userService.sendActivationPin(email);
        return "redirect:/activate?email=" + email;
    }

    @PostMapping("/activate/verify")
    public String verifyPin(@RequestParam String email,
            @RequestParam String pin, HttpServletResponse response,
            Model model) {
        boolean success = userService.activateAccount(email, pin, response);
        if (success) {
            return "redirect:/login?activated=true";
        }
        model.addAttribute("email", email);
        model.addAttribute("error", "الكود غلط أو انتهت صلاحيته");
        return "activate";
    }
}