package com.prueba.pruebanttdata.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ApiExceptionHandler {

//    @ExceptionHandler(value = {ApiRequestException.class})
//    public ResponseEntity<Object> handlerApiRequestException(ApiRequestException e) {
//
//        ApiException apiException = new ApiException(
//                e.getMessage(),
//                BAD_REQUEST,
//                LocalDate.now()
//        );
//
//        return new ResponseEntity<>(apiException, BAD_REQUEST);
//    }

    @ExceptionHandler(value = {ClientNotFoundException.class})
    public ResponseEntity<Object> handlerClientNotFoundException(ApiRequestException e) {

        ApiException apiException = new ApiException(
                e.getMessage(),
                BAD_REQUEST,
                LocalDate.now()
        );

        return new ResponseEntity<>(apiException, BAD_REQUEST);
    }
}
