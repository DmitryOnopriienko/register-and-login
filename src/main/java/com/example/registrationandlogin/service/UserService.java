package com.example.registrationandlogin.service;

import com.example.registrationandlogin.dto.SignUpDto;

public interface UserService {
    String login(String username, String password);
    String register(SignUpDto signUpDto);
}
