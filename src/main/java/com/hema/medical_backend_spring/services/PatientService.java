package com.hema.medical_backend_spring.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hema.medical_backend_spring.dto.UpdateBloodTypeDto;
import com.hema.medical_backend_spring.dto.UpdatePatientEmergencyDto;
import com.hema.medical_backend_spring.mapper.PatientMapper;
import com.hema.medical_backend_spring.model.Patient;
import com.hema.medical_backend_spring.model.Patient.BloodType;
import com.hema.medical_backend_spring.repository.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public Optional<Patient> getPatient(long userId) {
        return patientRepository.findById(userId);
    }

    public Patient updatePatientEmergency(UpdatePatientEmergencyDto dto, String email) {
        Patient patient = patientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        PatientMapper.mapFromEmergencyToPatient(dto, patient);

        return patientRepository.save(Objects.requireNonNull(patient));
    }

    public Patient updateBloodType(UpdateBloodTypeDto dto, String email) {
        Patient patient = patientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        PatientMapper.mapFromBloodTypeToPatient(dto, patient);
        return patientRepository.save(Objects.requireNonNull(patient));
    }
}
