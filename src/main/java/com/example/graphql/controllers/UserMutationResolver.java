package com.example.graphql.controllers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.annotations.IsValid;
import com.example.graphql.domains.User;
import com.example.graphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {

    private UserService userService;

    @Autowired
    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    public User createUser(@IsValid User user) {
        return this.userService.create(user);
    }
}
