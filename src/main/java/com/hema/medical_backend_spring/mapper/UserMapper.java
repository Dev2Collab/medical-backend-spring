package com.hema.medical_backend_spring.mapper;

import com.hema.medical_backend_spring.dto.UpdateUserPersonalDetailsDto;
import com.hema.medical_backend_spring.model.ProjectUser;

public class UserMapper {

    public static UpdateUserPersonalDetailsDto mapToUpdateUserPersonalDetailsDto(ProjectUser user,
            UpdateUserPersonalDetailsDto detailsDto) {
        detailsDto.setAddress(user.getAddress());
        detailsDto.setDateOfBirth(user.getDateOfBirth());
        detailsDto.setFullName(user.getFullName());
        detailsDto.setGender(user.getGender());
        detailsDto.setPhoneNumber(user.getPhoneNumber());
        return detailsDto;
    }

    public static ProjectUser mapToProjectUser(UpdateUserPersonalDetailsDto dto, ProjectUser user) {
        if (dto.getAddress() != null && !dto.getAddress().isBlank())
            user.setAddress(dto.getAddress());
        if (dto.getDateOfBirth() != null)
            user.setDateOfBirth(dto.getDateOfBirth());
        if (dto.getFullName() != null && !dto.getFullName().isBlank())
            user.setFullName(dto.getFullName());
        if (dto.getGender() != null)
            user.setGender(dto.getGender());
        if (dto.getPhoneNumber() != null && !dto.getPhoneNumber().isBlank())
            user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
}
