package com.example.graphql.controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.domains.User;
import com.example.graphql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
