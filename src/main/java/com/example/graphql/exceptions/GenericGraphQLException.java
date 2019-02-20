package com.example.graphql.exceptions;

public class GenericGraphQLException extends ExceptionHandler {

    public GenericGraphQLException(String message, int code) {
        super(message, code);
    }
}
