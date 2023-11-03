package com.spring.rest_api2.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Date fieldValue;

    public CustomerNotFoundException(){}

    public CustomerNotFoundException(Date timestamp,String details,String message){
        super(String.format("%s, %s with %s ID",timestamp,details, message));
        this.resourceName=message;
        this.fieldName=details;
        this.fieldValue=timestamp;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Date getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Date fieldValue) {
        this.fieldValue = fieldValue;
    }
}
