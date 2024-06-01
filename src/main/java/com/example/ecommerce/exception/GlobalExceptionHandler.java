package com.example.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(CategoryException categoryException){
        ErrorResponse errorResponse = new ErrorResponse(categoryException.getMessage(), Instant.now());
        return new ResponseEntity<>(errorResponse, categoryException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), Instant.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
