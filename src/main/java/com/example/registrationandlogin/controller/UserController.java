package com.example.registrationandlogin.controller;

import com.example.registrationandlogin.dto.LoginDto;
import com.example.registrationandlogin.dto.SignUpDto;
import com.example.registrationandlogin.service.UserService;
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
    @GetMapping("/registration")
    public String registration(@RequestBody SignUpDto signUpDto, Model model){
        String registrationResult = userService.register(signUpDto);

        if ("Registration successful".equals(registrationResult)) {
            model.addAttribute("successMessage", registrationResult);
            return "registration-success";
        } else {
            model.addAttribute("errorMessage", registrationResult);
            return "registration";
        }

    }
}
