package com.spring.rest_api2.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.spring.rest_api2.modal.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(CustomerNotFoundException ex,WebRequest req){
  ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleCustomerAlreadyExists(CustomerAlreadyExistsException ex,WebRequest req){
        ErrorResponse error=new ErrorResponse(new Date(), ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericException(Exception ex,WebRequest req){
  ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    
}
