package com.hema.medical_backend_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MedicalBackendSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalBackendSpringApplication.class, args);
	}

}
