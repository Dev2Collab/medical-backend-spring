package com.hema.medical_backend_spring.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "admins")
@PrimaryKeyJoinColumn(name = "user_id")
@OnDelete(action = OnDeleteAction.CASCADE)
@Getter @Setter
public class Admin extends ProjectUser {
    private String jobTitle;
    private String department;
    private String permissions;
    private String place;
     @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}