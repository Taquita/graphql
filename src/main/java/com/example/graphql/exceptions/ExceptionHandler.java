package com.example.graphql.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public abstract class ExceptionHandler extends RuntimeException implements GraphQLError {

    private int code;

    ExceptionHandler(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return HttpStatus.valueOf(code).name();
    }

    public String getException() {
        return this.getClass().getSimpleName();
    }

    @Override
    @JsonIgnore
    public Throwable getCause() {
        return null;
    }

    @Override
    @JsonIgnore
    public String getLocalizedMessage() {
        return this.getMessage();
    }

    @Override
    @JsonIgnore
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    @JsonIgnore
    public ErrorType getErrorType() {
        return null;
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

    @Override
    @JsonIgnore
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
