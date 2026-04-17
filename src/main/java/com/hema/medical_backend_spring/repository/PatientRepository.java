package com.hema.medical_backend_spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hema.medical_backend_spring.model.Patient;
import com.hema.medical_backend_spring.model.Patient.BloodType;

import jakarta.transaction.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

        Optional<Patient> findByEmail(String email);

        @Modifying
        @Transactional
        @Query("UPDATE Patient p SET " +
                        "p.emergencyContactName = COALESCE(:name, p.emergencyContactName), " +
                        "p.emergencyContactPhone = COALESCE(:phone, p.emergencyContactPhone) " +
                        "WHERE p.email = :email")
        int updateEmergencyContact(@Param("email") String email,
                        @Param("name") String emergencyContactName,
                        @Param("phone") String emergencyContactPhone);

        @Modifying
        @Transactional
        @Query("UPDATE Patient p SET " +
                        "p.bloodType = COALESCE(:bloodType, p.bloodType) " +
                        "WHERE p.email = :email")
        int updateBloodType(@Param("email") String email,
                        @Param("bloodType") BloodType bloodType);
}
