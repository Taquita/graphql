package com.example.graphql.controllers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.domains.User;
import com.example.graphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {

    private final UserService userService;

    @Autowired
    public UserMutationResolver(UserService userService) {
        this.userService = userService;
    }

    public User createUser(User user) {
        return this.userService.create(user);
    }

    public User updateUser(User user) {
        return this.userService.update(user);
    }

    public void removeUser(Long id) {
        this.userService.remove(id);
    }
}
