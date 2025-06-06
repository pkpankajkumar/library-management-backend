package com.librarymanagement.backend.controller;

import com.librarymanagement.backend.model.LoginRequest;
import com.librarymanagement.backend.model.LoginResponse;
import com.librarymanagement.backend.model.User;
import com.librarymanagement.backend.service.UserService;
import com.librarymanagement.backend.util.JwtUtil; // Utility for JWT generation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil; // Utility for JWT generation

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            String token = jwtUtil.generateToken(user.getUsername()); // Generate JWT token
            return ResponseEntity.ok().body(new LoginResponse(token)); // Return token in response
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
