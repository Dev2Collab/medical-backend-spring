package com.hema.medical_backend_spring.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AppointmentDto {
    private Long doctorId;
    private Long serviceId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String notes;
}