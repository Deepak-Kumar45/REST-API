package com.spring.rest_api2.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
    private String message;;
    public CustomerAlreadyExistsException(){}

    public CustomerAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
