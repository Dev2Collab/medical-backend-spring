package com.hema.medical_backend_spring.services;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hema.medical_backend_spring.model.MedicalRecord;
import com.hema.medical_backend_spring.model.Patient;
import com.hema.medical_backend_spring.model.ProjectUser;
import com.hema.medical_backend_spring.repository.MedicalRecordRepository;
import com.hema.medical_backend_spring.repository.PatientRepository;
import com.hema.medical_backend_spring.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;
    private final MedicalRecordRepository medicalRecordRepository;

    public void registerPatient(ProjectUser user) {

          // 1. إنشاء المريض
        Patient patient = new Patient();
        patient.setFullName(user.getFullName());
        patient.setEmail(user.getEmail());
        patient.setPassword(passwordEncoder.encode(user.getPassword()));
        patient.setPhoneNumber(user.getPhoneNumber());
        patient.setRole(ProjectUser.Role.PATIENT);
        
        Patient savedPatient = patientRepository.save(patient);

        // 2. إنشاء ملف طبي فاضي تلقائياً
        MedicalRecord record = new MedicalRecord();
        record.setPatient(savedPatient);
        medicalRecordRepository.save(record);
    }


    public boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private static final Pattern EMAIL_PATTERN = Pattern
            .compile("^[A-Za-z0-9][A-Za-z0-9._%+-]*@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public  Optional<ProjectUser> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public Optional<ProjectUser> loadUserByEmail(String email){
        return userRepo.findByEmail(email);
    }
}
