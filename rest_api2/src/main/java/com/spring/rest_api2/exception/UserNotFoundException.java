package com.spring.rest_api2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    private String errorMsg;

    public UserNotFoundException(){}
    
    public UserNotFoundException(String errorMsg){
        super(errorMsg);
        this.errorMsg=errorMsg;
        System.out.println(errorMsg);
    }
}
