package com.hema.medical_backend_spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hema.medical_backend_spring.model.ProjectUser;

public interface UserRepo extends JpaRepository<ProjectUser,Long> {

    Optional<ProjectUser> findByEmail(String email);

    
}
