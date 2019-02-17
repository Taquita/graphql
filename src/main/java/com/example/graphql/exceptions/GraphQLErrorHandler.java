package com.example.graphql.exceptions;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GraphQLErrorHandler implements graphql.servlet.GraphQLErrorHandler {
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getNested).collect(Collectors.toList());
    }

    private GraphQLError getNested(GraphQLError err) {
        if (err instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching exception = (ExceptionWhileDataFetching) err;
            if (exception.getException() instanceof GraphQLError)
                return (GraphQLError) exception.getException();
        }
        return err;
    }
}
