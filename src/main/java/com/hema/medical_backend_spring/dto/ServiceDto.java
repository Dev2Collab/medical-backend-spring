package com.hema.medical_backend_spring.dto;

import java.util.List;

import com.hema.medical_backend_spring.model.Doctor.Specialty;

import lombok.Data;

@Data
public class ServiceDto {
    private String name;
    private String description;
    private Double price;
    private Double startFrom;
    private Double consulating;
    private Specialty specialization;
    private List<String> features; // غيرها لـ String بسيط
}
