package com.hema.medical_backend_spring.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public void sendActivationPin(String toEmail, String pin) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setFrom("Medical System <ibrahimahmed2003eb@gmail.com>");
        message.setSubject("تفعيل الحساب");
        message.setText("كود التفعيل الخاص بك هو: " + pin + "\nصالح لمدة 15 دقيقة فقط.");
        mailSender.send(message);
    }
}