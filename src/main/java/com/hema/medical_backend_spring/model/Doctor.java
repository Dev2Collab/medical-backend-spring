package com.hema.medical_backend_spring.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "user_id")
@OnDelete(action = OnDeleteAction.CASCADE)
@Getter @Setter
public class Doctor extends ProjectUser {
    
@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
private List<Appointment> appointments;

    private String specialization;
    private String work;
    private String about;

     @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}