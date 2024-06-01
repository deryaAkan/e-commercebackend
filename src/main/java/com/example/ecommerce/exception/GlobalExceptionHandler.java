package com.example.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(NotFoundException NotFoundException){
        ErrorResponse errorResponse = new ErrorResponse(NotFoundException.getMessage(), Instant.now());
        return new ResponseEntity<>(errorResponse, NotFoundException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), Instant.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
