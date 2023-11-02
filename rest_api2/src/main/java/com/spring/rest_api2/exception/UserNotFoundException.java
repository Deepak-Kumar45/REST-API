package com.spring.rest_api2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.rest_api2.controller.ExceptionResponse;

@ResponseStatus(value=HttpStatus.NOT_FOUND)  // 404
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){}

    public UserNotFoundException(ExceptionResponse response){
    }
}

