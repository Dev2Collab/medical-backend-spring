package com.hema.medical_backend_spring.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.hema.medical_backend_spring.mapper.HelperDto;
import com.hema.medical_backend_spring.model.sub.Certification;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@PrimaryKeyJoinColumn(name = "user_id")
@OnDelete(action = OnDeleteAction.CASCADE)
@Getter
@Setter
public class Doctor extends ProjectUser {

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Certification> certifications;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    private String specialization;
    private String work;
    private String about;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public String getSpecialtyString() {
        return HelperDto.getSpecialtyString(this.specialty);
    }

 public enum Specialty {
    GENERAL,              // طب عام
    DENTISTRY,            // أسنان
    DERMATOLOGY,          // جلدية
    OPHTHALMOLOGY,        // عيون
    CARDIOLOGY,           // القلب والأوعية الدموية
    COSMETIC_DERMATOLOGY, // الجلدية والتجميل
    PEDIATRICS,           // طب الأطفال
    FAMILY_MEDICINE       // طب الأسرة
}

}