package com.kream.chouxkream.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandleController {

    // example
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exampleExceptionMethod(Exception e) {
        /*
            ...
         */
        log.error(e.getMessage());
        e.printStackTrace();

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
