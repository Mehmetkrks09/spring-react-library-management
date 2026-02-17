package com.ders.kutuphane.controller;

import com.ders.kutuphane.dto.AuthRequest;
import com.ders.kutuphane.dto.AuthResponse;
import com.ders.kutuphane.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthRequest request) {
        String message = authService.register(request.getUsername(), request.getPassword());
        AuthResponse response = new AuthResponse(null, message, request.getUsername());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        AuthResponse response = authService.login(
            request.getUsername(), 
            request.getPassword()
        );
        return ResponseEntity.ok(response);
    }
}