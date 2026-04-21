package com.hema.medical_backend_spring.mapper;

import org.springframework.security.core.Authentication;

import com.hema.medical_backend_spring.config.CustomUserDetails;
import com.hema.medical_backend_spring.model.ProjectUser;
import com.hema.medical_backend_spring.model.Doctor.Specialty;

public class HelperDto {

    static public ProjectUser getProjectUser(Authentication auth) {
        CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
        ProjectUser projectUser = userDetails.getProjectUser();
        return projectUser;
    }
public static String getSpecialtyString(Specialty specialty) {
    if (specialty == null) return "";

    switch (specialty) {
        case GENERAL: return "طب عام";
        case DENTISTRY: return "أسنان";
        case DERMATOLOGY: return "جلدية";
        case OPHTHALMOLOGY: return "عيون";
        case CARDIOLOGY: return "القلب والأوعية الدموية";
        case COSMETIC_DERMATOLOGY: return "الجلدية والتجميل";
        case PEDIATRICS: return "طب الأطفال";
        case FAMILY_MEDICINE: return "طب الأسرة";
        default: return specialty.name();
    }
}

}
