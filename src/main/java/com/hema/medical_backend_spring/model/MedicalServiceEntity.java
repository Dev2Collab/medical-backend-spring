package com.hema.medical_backend_spring.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.hema.medical_backend_spring.model.Doctor.Specialty;
import com.hema.medical_backend_spring.model.sub.ServiceFeatures;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medical_services")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class MedicalServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Double startFrom;
    private Double consulating;
    private Specialty specialization;

    // MedicalServiceEntity.java
    @OneToMany(mappedBy = "medicalService", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceFeatures> features; 

    private boolean mostRequested = false;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Admin admin;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
