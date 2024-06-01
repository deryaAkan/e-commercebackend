package com.example.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private String message;
    private Instant timestamp;

    public ErrorResponse(String message, Instant timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
