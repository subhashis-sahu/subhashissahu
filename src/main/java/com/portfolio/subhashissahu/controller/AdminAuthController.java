package com.portfolio.subhashissahu.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.subhashissahu.DTO.LoginRequest;
import com.portfolio.subhashissahu.config.JwtUtil;

@RestController
@RequestMapping("/api/admin")
public class AdminAuthController {

    private final JwtUtil jwtUtil;

    public AdminAuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {

        // HARD-CODED admin (for now)
        if ("admin".equals(req.getUserName()) &&
            "admin123".equals(req.getPassword())) {

            String token = jwtUtil.generateToken("admin");
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid credentials");
    }
}
