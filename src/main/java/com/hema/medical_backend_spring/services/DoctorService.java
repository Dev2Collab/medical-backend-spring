package com.hema.medical_backend_spring.services;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.hema.medical_backend_spring.dto.CertificationDto;
import com.hema.medical_backend_spring.mapper.HelperDto;
import com.hema.medical_backend_spring.model.Doctor;
import com.hema.medical_backend_spring.repository.CertificationRepository;
import com.hema.medical_backend_spring.repository.DoctorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final CertificationRepository certificationRepository;


    public Optional<Doctor> getDoctor(long userId) {
        return doctorRepository.findById(userId);
    }

   public void addCertification(CertificationDto dto ,Authentication authentication){
    certificationRepository.insertCertification(HelperDto.getProjectUser(authentication).getId(),dto.getName(),dto.getPlace(),dto.getOrganization(),dto.getPhoto());
   }

    // public void updateBloodType(UpdateBloodTypeDto dto, String email) {
    //     int updatedRows = patientRepository.updateBloodType(email, dto.getBloodType());

    //     if (updatedRows == 0) {
    //         throw new RuntimeException("User not found");
    //     }
    // }
}
