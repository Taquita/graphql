package com.example.graphql.exceptions;

import graphql.GraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ExceptionHandlers {

    @ExceptionHandler(GenericException.class)
    GraphQLError handleException(GenericException e) {
        return new CustomThrowableGraphQLError(e);
    }

    @ExceptionHandler(TransactionSystemException.class)
    GraphQLError handleException(TransactionSystemException e) {
        return new CustomThrowableGraphQLError(new InvalidException(catchErrorReason(e), 500));
    }

    private String catchErrorReason(TransactionSystemException e) {
        String regex = "(?<=interpolatedMessage=').*?(?=\',)";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(e.getCause().getCause().getMessage());
        if (matcher.find())
            return matcher.group();
        return "Could not identify validation error";
    }
}
