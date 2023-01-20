package com.skypro.coursework.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String massage) {
        super(massage);
    }
}
