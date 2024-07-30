package com.splitwise.advice;

import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<Map<String,String>> internalServerExceptionalHandler(Exception ex){

        Map<String,String> map = new HashMap<>();
        map.put("ErrorMessage",ex.getMessage());

        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<Map<String,String>> globalExceptionHandler(Exception ex){
        Map<String,String> map = new HashMap<>();
        map.put("ErrorMessage",ex.getMessage());
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();


        ex.getBindingResult().getAllErrors().forEach(error -> {
            errors.put(error.getCode(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.PARTIAL_CONTENT);
    }

}
