package com.example.registrationandlogin.service.impl;

import com.example.registrationandlogin.entity.User;
import com.example.registrationandlogin.exception.IncorrectPasswordException;
import com.example.registrationandlogin.exception.NotFoundException;
import com.example.registrationandlogin.repository.UserRepository;
import com.example.registrationandlogin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User %s not found".formatted(username)));
        if (user.getPassword().equals(password)) {
            return "Login success";
        }
        throw new IncorrectPasswordException("Incorrect password");
    }
}
