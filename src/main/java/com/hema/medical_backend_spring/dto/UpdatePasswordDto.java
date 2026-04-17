package com.hema.medical_backend_spring.dto;

import lombok.Data;

@Data
public class UpdatePasswordDto {
    private String oldPass;
    private String newPass;
}

