package com.walmart.ddd.rentroom.infrastructure.exception;

public class ApiException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable e) {
        super(message, e);
    }

}
