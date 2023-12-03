package com.example.registrationandlogin.service.impl;

import com.example.registrationandlogin.dto.SignUpDto;
import com.example.registrationandlogin.entity.User;
import com.example.registrationandlogin.exception.DuplicateUsernameException;
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
    @Override
    public String register(SignUpDto signUpDto) {
        // Check if the username is already taken
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            throw new DuplicateUsernameException("Username is already taken");
        }

        // Create a new user entity
        User newUser = new User();
        newUser.setUsername(signUpDto.getUsername());
        newUser.setPassword(signUpDto.getPassword());

        // Save the user to the database
        userRepository.save(newUser);

        return "Registration successful";
    }
}
