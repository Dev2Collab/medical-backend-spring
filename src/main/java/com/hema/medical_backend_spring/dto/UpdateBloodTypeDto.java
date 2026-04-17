package com.hema.medical_backend_spring.dto;

import com.hema.medical_backend_spring.model.Patient.BloodType;

import lombok.Data;

@Data
public class UpdateBloodTypeDto {
    BloodType bloodType;
}
