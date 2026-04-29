package com.hema.medical_backend_spring.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hema.medical_backend_spring.model.Admin;
import com.hema.medical_backend_spring.repository.AdminRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public Optional<Admin> getAdmin(long userId) {
        return adminRepository.findById(userId);
    }

    // public void updateDoctor(DoctorDto dto, Authentication authentication) {

    //     doctorRepository.updateDoctorPartial(
    //             HelperDto.getProjectUser(authentication).getId(),
    //             dto.getSpecialization(),
    //             dto.getWork(), dto.getAbout(),
    //             dto.getSpecialty());
    // }

    // public void updateBloodType(UpdateBloodTypeDto dto, String email) {
    // int updatedRows = patientRepository.updateBloodType(email,
    // dto.getBloodType());

    // if (updatedRows == 0) {
    // throw new RuntimeException("User not found");
    // }
    // }
}
