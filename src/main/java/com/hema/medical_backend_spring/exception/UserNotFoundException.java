package com.hema.medical_backend_spring.exception;

public class UserNotFoundException  extends RuntimeException {
     public UserNotFoundException(String err){
        super(err);
    }
}
