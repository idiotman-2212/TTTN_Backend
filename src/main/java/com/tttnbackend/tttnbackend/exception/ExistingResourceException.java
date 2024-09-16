package com.tttnbackend.tttnbackend.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExistingResourceException extends RuntimeException{
    private final String errorMessage;
}
