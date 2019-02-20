package com.example.graphql.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oembedler.moon.graphql.boot.error.ThrowableGraphQLError;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public class CustomThrowableGraphQLError extends ThrowableGraphQLError {

    private final GenericException exception;

    CustomThrowableGraphQLError(GenericException throwable) {
        super(throwable);
        this.exception = throwable;
    }

    public int getCode() {
        return this.exception.code;
    }

    public String getStatus() {
        return HttpStatus.valueOf(this.exception.code).name();
    }

    @Override
    @JsonIgnore
    public List<Object> getPath() {
        return null;
    }

    @Override
    @JsonIgnore
    public Map<String, Object> getExtensions() {
        return null;
    }

}
