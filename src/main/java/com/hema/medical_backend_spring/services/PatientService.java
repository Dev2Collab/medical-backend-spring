package com.hema.medical_backend_spring.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hema.medical_backend_spring.model.Patient;
import com.hema.medical_backend_spring.model.ProjectUser;
import com.hema.medical_backend_spring.repository.PatientRepository;
import com.hema.medical_backend_spring.repository.UserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientService {
    private final UserRepo userRepo;
    private final PatientRepository patientRepository;


 public Optional<ProjectUser> loadUserData(String email){
        return userRepo.findByEmail(email);
    }
public Optional<Patient> getPatient(long userId){
    return patientRepository.findById(userId);
}
    
    
    
}
