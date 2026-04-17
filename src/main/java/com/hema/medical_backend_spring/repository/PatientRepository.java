package com.hema.medical_backend_spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hema.medical_backend_spring.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

        Optional<Patient> findByEmail(String email);

}
