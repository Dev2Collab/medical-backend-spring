package com.hema.medical_backend_spring.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PageNotFoundException.class)
    public ResponseEntity<String> handleCustomerAlreadyExistException(){ 
           return new ResponseEntity<>("notFound", HttpStatus.BAD_REQUEST);
    }
    
}
