package com.example.graphql.controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.domains.User;
import com.example.graphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {

    private UserService userService;

    @Autowired
    public UserQueryResolver(UserService userService) {
        this.userService = userService;
    }

    public User getUser(Long id) {
        return this.userService.getById(id);
    }

    public List<User> getUsers() {
        return this.userService.list();
    }

}
