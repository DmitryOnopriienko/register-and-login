package com.example.registrationandlogin.exception;

public class DuplicateUsernameException extends RuntimeException{
    public DuplicateUsernameException(String message) {
        super(message);
    }
}
