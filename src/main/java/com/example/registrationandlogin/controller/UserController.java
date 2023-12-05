package com.example.registrationandlogin.controller;

import com.example.registrationandlogin.dto.LoginDto;
import com.example.registrationandlogin.dto.SignUpDto;
import com.example.registrationandlogin.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        return userService.login(loginDto.getUsername(), loginDto.getPassword());
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody SignUpDto signUpDto) {
        String registrationResult = userService.register(signUpDto);

        if ("Registration successful".equals(registrationResult)) {
            return ResponseEntity.status(HttpStatus.OK).body(registrationResult);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registrationResult);
        }
    }
}
