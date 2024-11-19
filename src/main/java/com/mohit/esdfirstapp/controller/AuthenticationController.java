package com.mohit.esdfirstapp.controller;

import com.mohit.esdfirstapp.dto.LoginRequest;
import com.mohit.esdfirstapp.dto.LoginResponse;
import com.mohit.esdfirstapp.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final CustomerService customerService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        String token = customerService.login(request);
        LoginResponse response = new LoginResponse("User logged in successfully", token);
        return ResponseEntity.ok(response);
    }
}