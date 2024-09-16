package com.tttnbackend.tttnbackend.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException{
    private final String errorMessages;
}
