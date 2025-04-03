package com.example.Jour4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.Jour4.model.User;
import com.example.Jour4.repository.UserRepository;
import java.util.Optional;

@SpringBootApplication
public class Jour4Application {

    public static void main(String[] args) {
        SpringApplication.run(Jour4Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }
        };
    }
}

