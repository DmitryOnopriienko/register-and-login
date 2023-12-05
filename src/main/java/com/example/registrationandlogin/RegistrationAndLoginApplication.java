package com.example.registrationandlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RegistrationAndLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationAndLoginApplication.class, args);
    }
}
