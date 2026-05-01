package com.hema.medical_backend_spring.exception;

public class NotValidTimeException  extends RuntimeException {
     public NotValidTimeException(String err){
        super(err);
    }
}
