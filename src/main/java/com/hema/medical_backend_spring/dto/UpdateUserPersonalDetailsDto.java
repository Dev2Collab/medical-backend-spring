package com.hema.medical_backend_spring.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UpdateUserPersonalDetailsDto {
    private String fullName;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
}
