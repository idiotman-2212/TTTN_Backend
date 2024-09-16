package com.tttnbackend.tttnbackend.exception;

import lombok.Data;

@Data
public class InvalidInputException extends RuntimeException{
    private final String errorMessage;
}
