package com.example.graphql.exceptions;

public class InvalidException extends GenericException {

    public InvalidException(String s, int code) {
        super(s, code);
    }

}
