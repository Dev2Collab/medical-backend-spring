package com.hema.medical_backend_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatusController {

    @GetMapping("/success")
    public String successPage() {
        return "ui/success";
    }

    @GetMapping("/fail")
    public String failPage() {
        return "ui/fail";
    }
}
