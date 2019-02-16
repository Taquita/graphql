package com.example.graphql.controllers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.domains.User;
import com.example.graphql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String getHello() {
        return "Hello World";
    }

    public User getUser() {
        return new User(1L, "John", "John@gmail.com");
    }

//    public List<User> getUsers() {
//        List<User> users = new ArrayList<User>();
//        users.add(new User(1L, "John", "John@gmail.com"));
//        users.add(new User(2L, "Adolf", "Adolf@gmail.com"));
//        users.add(new User(3L, "Kart", "Kart@gmail.com"));
//        return users;
//    }

}
