package com.annton.lab1.controllers;

import com.annton.lab1.dto.UserRequestDTO;
import com.annton.lab1.entities.User;
import com.annton.lab1.services.JwtService;
import com.annton.lab1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequestDTO userRequestDTO) {
        User user = userService.register(userRequestDTO.username(), userRequestDTO.password());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(String.format("User %s registered successfully", user.getUsername()));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO userRequestDto) {
        String token=userService.login(userRequestDto.username(), userRequestDto.password());
        return ResponseEntity.ok(token);
    }

}
