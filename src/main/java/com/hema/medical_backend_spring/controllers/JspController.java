package com.hema.medical_backend_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class JspController {
    
   @GetMapping("message")
   public ModelAndView getMethodName() {
        ModelAndView mv=new ModelAndView();
        mv.addObject("message","welcome to here ");
        mv.setViewName("auth/login");
      return mv;
   }
    
}
