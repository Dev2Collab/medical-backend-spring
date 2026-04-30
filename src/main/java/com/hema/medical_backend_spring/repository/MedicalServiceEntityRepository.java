package com.hema.medical_backend_spring.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hema.medical_backend_spring.model.Doctor.Specialty;

import jakarta.transaction.Transactional;

import com.hema.medical_backend_spring.model.MedicalServiceEntity;

public interface MedicalServiceEntityRepository extends JpaRepository<MedicalServiceEntity, Long> {

     Page<MedicalServiceEntity> findBySpecialization(Specialty specialization,Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE MedicalServiceEntity s SET " +
           "s.name = COALESCE(:name, s.name), " +
           "s.description = COALESCE(:description, s.description), " +
           "s.price = COALESCE(:price, s.price), " +
           "s.startFrom = COALESCE(:startFrom, s.startFrom), " +
           "s.consulating = COALESCE(:consulating, s.consulating), " +
           "s.specialization = COALESCE(:specialization, s.specialization) " +
           "WHERE s.id = :id")
    void updateServicePartial(@Param("id") Long id,
                              @Param("name") String name,
                              @Param("description") String description,
                              @Param("price") Double price,
                              @Param("startFrom") Double startFrom,
                              @Param("consulating") Double consulating,
                              @Param("specialization") Specialty specialization);
}
    

