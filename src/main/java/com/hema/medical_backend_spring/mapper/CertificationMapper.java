package com.hema.medical_backend_spring.mapper;

import com.hema.medical_backend_spring.dto.CertificationDto;
import com.hema.medical_backend_spring.model.Doctor;
import com.hema.medical_backend_spring.model.sub.Certification;

public class CertificationMapper {
    
    // Convert DTO → Entity
    public static Certification toEntity(CertificationDto dto,long id, Doctor doctor) {
        Certification certification = new Certification();
        certification.setDoctor(doctor);
        certification.setName(dto.getName());
        certification.setPlace(dto.getPlace());
        certification.setOrganization(dto.getOrganization());
        certification.setPhoto(dto.getPhoto());
        certification.setId(id);
        return certification;
    }

    // Convert Entity → DTO
    public static CertificationDto toDto(Certification certification) {
        CertificationDto dto = new CertificationDto();
        dto.setName(certification.getName());
        dto.setPlace(certification.getPlace());
        dto.setOrganization(certification.getOrganization());
        dto.setPhoto(certification.getPhoto());
        return dto;
    }
}
