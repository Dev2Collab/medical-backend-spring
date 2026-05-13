package com.hema.medical_backend_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ContactController {
    @GetMapping("/contact")
    public String getContactPage() {
        return new String("contact");
    }
    // TODO make the contact us send work
    // TODO do a working publishing

    
}
