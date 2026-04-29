package com.hema.medical_backend_spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hema.medical_backend_spring.dto.ServiceDto;
import com.hema.medical_backend_spring.model.Admin;
import com.hema.medical_backend_spring.model.MedicalServiceEntity;
import com.hema.medical_backend_spring.model.sub.ServiceFeatures;
import com.hema.medical_backend_spring.repository.AdminRepository;
import com.hema.medical_backend_spring.repository.MedicalServiceEntityRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MedicalServiceService {
    private final MedicalServiceEntityRepository medicalServiceRepository;
    private final AdminRepository adminRepository;

    public List<MedicalServiceEntity> getAllServices() {
        return medicalServiceRepository.findAll();
    }

    public void createService(ServiceDto dto, String adminEmail) {
         Admin admin = adminRepository.findByEmail(adminEmail)
            .orElseThrow(() -> new RuntimeException("Admin not found"));
    
    MedicalServiceEntity service = new MedicalServiceEntity();
    service.setAdmin(admin);
        service.setName(dto.getName());
        service.setDescription(dto.getDescription());
        service.setPrice(dto.getPrice());
        service.setStartFrom(dto.getStartFrom());
        service.setConsulating(dto.getConsulating());
        service.setSpecialization(dto.getSpecialization());

        if (dto.getFeatures() != null) {
            List<ServiceFeatures> features = dto.getFeatures()
                    .stream()
                    .filter(f -> f != null && !f.isBlank())
                    .map(f -> {
                        ServiceFeatures feature = new ServiceFeatures();
                        feature.setFeature(f);
                        feature.setMedicalService(service);
                        return feature;
                    })
                    .collect(Collectors.toList());
            service.setFeatures(features);
        }

        medicalServiceRepository.save(service);
    }
}