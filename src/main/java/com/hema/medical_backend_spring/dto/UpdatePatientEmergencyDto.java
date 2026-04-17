package com.hema.medical_backend_spring.dto;

import lombok.Data;

@Data
public class UpdatePatientEmergencyDto {
    private String emergencyContactName;
    private String emergencyContactPhone;
}
