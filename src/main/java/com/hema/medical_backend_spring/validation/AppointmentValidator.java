package com.hema.medical_backend_spring.validation;

import java.time.LocalTime;
import java.util.Set;

import com.hema.medical_backend_spring.dto.AppointmentDto;
import com.hema.medical_backend_spring.repository.AppointmentRepository;

public class AppointmentValidator {
    static public boolean isSlotTaken( AppointmentRepository appointmentRepository ,AppointmentDto dto) {
     return  appointmentRepository
                .findByDoctorIdAndAppointmentDate(dto.getDoctorId(), dto.getAppointmentDate())
                .stream()
                .anyMatch(a -> a.getAppointmentTime().equals(dto.getAppointmentTime()));
    }

    public static boolean isTimeAllowed(LocalTime appointmentTime) {
        return allowedTimes.contains(appointmentTime);
    }

    private static final Set<LocalTime> allowedTimes = Set.of(
        LocalTime.of(9, 0),
        LocalTime.of(11, 30),
        LocalTime.of(16, 30),
        LocalTime.of(19, 0)
    );

    
}
