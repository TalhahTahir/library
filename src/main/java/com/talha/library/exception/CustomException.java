package com.talha.library.exception;

public class CustomException extends RuntimeException {
    private final String details;

    public CustomException(String message, String details) {
        super(message);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}


