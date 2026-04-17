package com.hema.medical_backend_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hema.medical_backend_spring.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {}
