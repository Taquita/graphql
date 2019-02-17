package com.example.graphql.exceptions;

public class EntityNotFoundException extends ExceptionHandler {

    public EntityNotFoundException(String message, int status) {
        super(message, status);
    }

}
