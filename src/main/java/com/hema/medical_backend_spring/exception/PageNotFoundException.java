package com.hema.medical_backend_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(String pageName){
        super(pageName);
    }
}
