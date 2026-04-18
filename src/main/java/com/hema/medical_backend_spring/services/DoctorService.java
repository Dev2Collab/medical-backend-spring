package com.hema.medical_backend_spring.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hema.medical_backend_spring.model.Doctor;
import com.hema.medical_backend_spring.repository.DoctorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Optional<Doctor> getDoctor(long userId) {
        return doctorRepository.findById(userId);
    }

   

    // public void updateBloodType(UpdateBloodTypeDto dto, String email) {
    //     int updatedRows = patientRepository.updateBloodType(email, dto.getBloodType());

    //     if (updatedRows == 0) {
    //         throw new RuntimeException("User not found");
    //     }
    // }
}
