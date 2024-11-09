package com.ak.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> ResourceNotFoundExceptionHandler(Exception exception)
    {
       Response res =  Response.builder().message(exception.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<Response>(res, HttpStatus.NOT_FOUND);
    }
}
