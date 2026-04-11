package com.hema.medical_backend_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class AboutController {
    @GetMapping("/about")
    public String getAboutPage() {
        return new String("about");
    } 
}
