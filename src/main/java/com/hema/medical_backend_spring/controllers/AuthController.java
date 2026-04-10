package com.hema.medical_backend_spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hema.medical_backend_spring.model.ProjectUser;
import com.hema.medical_backend_spring.services.UserService;

@Controller
public class AuthController {

    

    @Autowired
    private UserService userService;



    @GetMapping("/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }

        return "auth/login";
    }

    @GetMapping("/signup")
    public String getSignupPage(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String registerUser(
            @ModelAttribute ProjectUser user,
            @RequestParam(name = "passwordCheck", required = false) String passwordCheck,
            Model model) {

        // chek fields
        if (user.getEmail() == null || user.getPassword() == "" || user.getFullName() == "") {
            model.addAttribute("error", "جميع الحقول مطلوبة");
            return "auth/signup";
        }
        // check matching password
        if (user.getPassword() == null || !user.getPassword().equals(passwordCheck)) {
            model.addAttribute("error", "كلمات المرور غير متطابقة");
            return "auth/signup";
        }
        //check if its valid name
        if(!userService.isValidEmail(user.getEmail())){
            System.out.println(userService.isValidEmail(user.getEmail()));
            model.addAttribute("error", "البريد الالكتروني غير صالح");
            return "auth/signup";
        }

        //check if user exist 
        if(userService.findByEmail(user.getEmail()).isPresent()){
            model.addAttribute("error", "البريد الالكتروني مستخدم بالفعل");
            return "auth/signup";
        }
        

        System.out.println(user.toString());
        userService.saveUser(user);
        return "redirect:/login";
    }

}
