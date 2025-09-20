package com.ricardo.practica2.exception;

import com.ricardo.practica2.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        log.error("UserNotFoundException: {}", ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse("USER_NOT_FOUND", ex.getMessage()), HttpStatus.NOT_FOUND);

    }



    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){

        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {

            errors.put(error.getField(), error.getDefaultMessage());
        });
        log.error("Validation failed {}", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception ex) {
        log.error("Unhandled Exception: {}", ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse("INTERNAL_SERVER_ERROR", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
