package com.tttnbackend.tttnbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectNotValidException.class)
    public ResponseEntity<?> handleException (ObjectNotValidException exception){
        return ResponseEntity.badRequest().body(exception.getErrorsMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleResourceNotFound(ResourceNotFoundException exception){
        return ApiErrorResponse
                .builder()
                .statusCode(404)
                .dateTime(LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")))
                .message(exception.getErrorMessages())
                .build();
    }

    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleInvalidInput(InvalidInputException exception){
        return ApiErrorResponse
                .builder()
                .statusCode(400)
                .dateTime(LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")))
                .message(exception.getErrorMessage())
                .build();
    }
    @ExceptionHandler(ExistingResourceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleResourceExisted(ExistingResourceException exception){
        return ApiErrorResponse.builder()
                .statusCode(400)
                .dateTime(LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")))
                .message(exception.getErrorMessage())
                .build();
    }
}
