package com.portfolio.api_sboot_digital_library.infra.exception;

public class UnavailableException extends RuntimeException {
    public UnavailableException(String message) {
        super(message);
    }
}
