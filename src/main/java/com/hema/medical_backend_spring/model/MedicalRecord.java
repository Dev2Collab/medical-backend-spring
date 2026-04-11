package com.hema.medical_backend_spring.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medical_records")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "patient_id",unique = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;
    

    @ElementCollection
    @CollectionTable(name = "allergies", joinColumns = @JoinColumn(name = "record_id"))
    @Column(name = "allergy")
    private List<String> allergies;

    @ElementCollection
    @CollectionTable(name = "chronic_diseases", joinColumns = @JoinColumn(name = "record_id"))
    @Column(name = "disease")
    private List<String> chronicDiseases;

    @ElementCollection
    @CollectionTable(name = "medications", joinColumns = @JoinColumn(name = "record_id"))
    @Column(name = "medication")
    private List<String> medications;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}