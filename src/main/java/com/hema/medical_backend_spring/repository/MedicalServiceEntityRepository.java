package com.hema.medical_backend_spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hema.medical_backend_spring.model.MedicalServiceEntity;

public interface MedicalServiceEntityRepository extends JpaRepository<MedicalServiceEntity, Long> {
    
}
