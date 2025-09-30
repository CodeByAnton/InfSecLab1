package com.annton.lab1.services;

import com.annton.lab1.entities.User;
import com.annton.lab1.exeptions.InvalidCredentialsException;
import com.annton.lab1.exeptions.UsernameAlreadyExistsException;
import com.annton.lab1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public User register(String username, String password) {

        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public String login(String username, String password) {
        if (!checkCredentials(username, password)){
            throw new InvalidCredentialsException("Wrong credentials");
        }

        return userRepository.findByUsername(username)
        .map(jwtService::generateToken)
        .orElseThrow(() -> new UsernameNotFoundException("Username or password is incorrect"));

    }

    public boolean checkCredentials(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> passwordEncoder.matches(password,user.getPassword()))
                .orElse(false);
    }
}
