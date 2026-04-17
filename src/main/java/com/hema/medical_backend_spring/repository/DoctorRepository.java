package com.hema.medical_backend_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hema.medical_backend_spring.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {}
