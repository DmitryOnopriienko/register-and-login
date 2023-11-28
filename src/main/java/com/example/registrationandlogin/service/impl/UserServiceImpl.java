package com.example.registrationandlogin.service.impl;

import com.example.registrationandlogin.repository.UserRepository;
import com.example.registrationandlogin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }
}
