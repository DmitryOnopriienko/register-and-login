package com.example.registrationandlogin.controller;

import com.example.registrationandlogin.dto.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        return "login";
    }
}
