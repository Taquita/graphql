package com.example.graphql.domains;

import com.example.graphql.exceptions.EntityNotFoundException;
import com.example.graphql.exceptions.GraphQLErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericDomains<T> {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public T isValid(T value) {
        Set<ConstraintViolation<T>> violations = validator.validate(value);
        Set<EntityNotFoundException> exceptions = violations.stream().
                map((violation) -> new EntityNotFoundException(violation.getMessage(), 500))
                .collect(Collectors.toSet());
        if (exceptions.size() > 0)
            new GraphQLErrorHandler().processErrors(new ArrayList<>(exceptions));
        return value;
    }
}
