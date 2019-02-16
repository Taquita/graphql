package com.example.graphql.services;

import com.example.graphql.domains.User;
import com.example.graphql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return this.userRepository.save(user);
    };

    public User update(User user) {
        return this.userRepository.save(user);
    }
}
