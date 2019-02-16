package com.example.graphql.controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.domains.User;
import com.example.graphql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private UserRepository userRepository;

    @Autowired
    public QueryResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String getHello() {
        return "Hello World";
    }

    public User getUser() {
        return new User(1L, "John", "John@gmail.com");
    }

}
