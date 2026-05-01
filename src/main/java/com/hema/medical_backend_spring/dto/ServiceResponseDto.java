package com.hema.medical_backend_spring.dto;

import lombok.Data;

@Data
public class ServiceResponseDto {
  private Long id;
  private String name;
  private Double price;
  private Double startFrom;
    private Double consulating;

}
