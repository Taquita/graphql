package com.example.graphql.exceptions;

public class GenericGraphQLException extends ExceptionHandler {

    GenericGraphQLException(String message, int code) {
        super(message, code);
    }
}
