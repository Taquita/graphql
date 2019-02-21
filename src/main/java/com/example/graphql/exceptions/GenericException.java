package com.example.graphql.exceptions;

abstract class GenericException extends RuntimeException {

    final Integer code;

    GenericException(String s, Integer code) {
        super(s);
        this.code = code;
    }


}
