package com.hema.medical_backend_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hema.medical_backend_spring.model.sub.Certification;

import jakarta.transaction.Transactional;

public interface CertificationRepository extends JpaRepository<Certification, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO certifications (doctor_id, name, place, organization, photo) " +
            "VALUES (:doctorId, :name, :place, :organization, :photo)", nativeQuery = true)
     void insertCertification(@Param("doctorId") Long doctorId,
            @Param("name") String name,
            @Param("place") String place,
            @Param("organization") String organization,
            @Param("photo") String photo);
}
