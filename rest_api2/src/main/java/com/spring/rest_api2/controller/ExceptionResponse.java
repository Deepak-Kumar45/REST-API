package com.spring.rest_api2.controller;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private int status;
    private String error;
    private String path;
    private String message;
     public ExceptionResponse() {
    }
    public ExceptionResponse(int status, String error, String path, String message,Date timestamp) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
        this.message = message;
    }

}
