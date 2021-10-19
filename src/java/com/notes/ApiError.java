package com.notes;

import org.springframework.http.HttpStatus;

public class ApiError extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public ApiError(HttpStatus status, String message) {
        this.status= status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

}
