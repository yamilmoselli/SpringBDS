package com.springbds.SpringBDS.error;

public class LocalNotFoundException extends RuntimeException {
    public LocalNotFoundException(String message) {
        super(message);
    }
}
