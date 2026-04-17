package com.hema.medical_backend_spring.exception;

public class IncorrectPasswordException  extends RuntimeException {
     public IncorrectPasswordException(String err){
        super(err);
    }
}
