package com.hema.medical_backend_spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.hema.medical_backend_spring.dto.DoctorDto;
import com.hema.medical_backend_spring.mapper.HelperDto;
import com.hema.medical_backend_spring.model.Doctor;
import com.hema.medical_backend_spring.model.Doctor.Specialty;
import com.hema.medical_backend_spring.repository.DoctorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Optional<Doctor> getDoctor(long userId) {
        return doctorRepository.findById(userId);
    }

    public void updateDoctor(DoctorDto dto, Authentication authentication) {

        doctorRepository.updateDoctorPartial(
                HelperDto.getProjectUser(authentication).getId(),
                dto.getSpecialization(),
                dto.getWork(), dto.getAbout(),
                dto.getSpecialty());
    }

    public Page<Doctor> getDoctorsBySpecialty(String specialty,int page,int size ) {
        Pageable pageable = PageRequest.of(page, size);


        if (specialty != null) {
            switch (specialty.toUpperCase()) {
                case "GENERAL":
                    return doctorRepository.findBySpecialty(Specialty.GENERAL,pageable);
                case "DENTISTRY":
                    return doctorRepository.findBySpecialty(Specialty.DENTISTRY,pageable);
                case "DERMATOLOGY":
                    return doctorRepository.findBySpecialty(Specialty.DERMATOLOGY,pageable);
                case "OPHTHALMOLOGY":
                    return doctorRepository.findBySpecialty(Specialty.OPHTHALMOLOGY,pageable);
                default:
                    return doctorRepository.findAll(pageable);
            }
        }
        return doctorRepository.findAll(pageable);
    }

    public Page<Doctor> searchDoctors(String s,int page,int size ) {
        Pageable pageable = PageRequest.of(page, size);
 
        if(s!=null){
            return doctorRepository.findByFullNameContainingIgnoreCaseOrAboutContainingIgnoreCaseOrSpecializationContainingIgnoreCaseOrWorkContainingIgnoreCase( s, s, s, s,pageable);
        }
        return doctorRepository.findAll(pageable);
    }

    // public void updateBloodType(UpdateBloodTypeDto dto, String email) {
    // int updatedRows = patientRepository.updateBloodType(email,
    // dto.getBloodType());

    // if (updatedRows == 0) {
    // throw new RuntimeException("User not found");
    // }
    // }
}
