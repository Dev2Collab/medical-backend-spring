package com.hema.medical_backend_spring.mapper;

import org.springframework.security.core.Authentication;

import com.hema.medical_backend_spring.config.CustomUserDetails;
import com.hema.medical_backend_spring.model.ProjectUser;

public class HelperDto {

    static public ProjectUser getProjectUser(Authentication auth){
    CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
    ProjectUser projectUser = userDetails.getProjectUser();
    return projectUser;

    }
}
