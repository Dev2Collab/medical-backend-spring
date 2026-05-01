package com.hema.medical_backend_spring.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.security.core.Authentication;

import com.hema.medical_backend_spring.config.CustomUserDetails;
import com.hema.medical_backend_spring.model.ProjectUser;
import com.hema.medical_backend_spring.model.Appointment.AppointmentStatus;
import com.hema.medical_backend_spring.model.Doctor.Specialty;

public class HelperDto {

    static public ProjectUser getProjectUser(Authentication auth) {
        CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
        ProjectUser projectUser = userDetails.getProjectUser();
        return projectUser;
    }

    public static String getSpecialtyString(Specialty specialty) {
        if (specialty == null)
            return "";

        switch (specialty) {
            case GENERAL:
                return "طب عام";
            case DENTISTRY:
                return "أسنان";
            case DERMATOLOGY:
                return "جلدية";
            case OPHTHALMOLOGY:
                return "عيون";
            case CARDIOLOGY:
                return "القلب والأوعية الدموية";
            case COSMETIC_DERMATOLOGY:
                return "الجلدية والتجميل";
            case PEDIATRICS:
                return "طب الأطفال";
            case FAMILY_MEDICINE:
                return "طب الأسرة";
            default:
                return specialty.name();
        }
    }

    public static String getStatusString(AppointmentStatus status) {
        if (status == null)
            return "";

        switch (status) {
            case PENDING:
                return "قيد الانتظار";
            case CONFIRMED:
                return "مؤكد";
            case CANCELLED:
                return "ملغى";
            default:
                return status.name();
        }
    }

    public static String getDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ar"));
        return date.format(formatter);
    }

    public static String getTime(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a", new Locale("ar"));
        return time.format(formatter);
    }

    public static String getTwoChars(String name) {
        String[] parts = name.trim().split("\\s+");

        StringBuilder initials = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                initials.append(part.charAt(0));
            }
        }
        String result = initials.toString();

        if (result.length() == 1) {
            return result.toUpperCase();
        }
        if (result.length() > 2) {
            return result.substring(0, 2).toLowerCase();
        }

        return result.toLowerCase();

    }

}
