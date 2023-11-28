package com.example.registrationandlogin.service;

import com.example.registrationandlogin.exception.NotFoundException;
import com.example.registrationandlogin.repository.UserRepository;
import com.example.registrationandlogin.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void shouldThrowExceptionWithUsernameWhenUserNotFound() {
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(NotFoundException.class, () -> {
            UserService userService = new UserServiceImpl(userRepository);
            userService.login("user", "password");
        });
        assertEquals("User user not found", exception.getMessage());
    }
}
