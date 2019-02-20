package com.example.graphql.exceptions;

abstract class GenericException extends RuntimeException {

    final int code;

    GenericException(String s, int code) {
        super(s);
        this.code = code;
    }


}
