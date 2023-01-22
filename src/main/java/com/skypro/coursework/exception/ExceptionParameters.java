package com.skypro.coursework.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.logging.Handler;

@ControllerAdvice
public class ExceptionParameters {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handlerBadRequestException(RuntimeException a, WebRequest b) {
        return new ResponseEntity<>(a.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handlerNotFoundException(RuntimeException a, WebRequest b) {
        return new ResponseEntity<>(a.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
