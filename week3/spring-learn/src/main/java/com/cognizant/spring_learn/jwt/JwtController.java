package com.cognizant.spring_learn.jwt;

import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController {

    private JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest request) {

        if ("user".equals(request.getUsername()) &&
                "pwd".equals(request.getPassword())) {

            String token = jwtUtil.generateToken(request.getUsername());

            return new JwtResponse(token);
        }

        throw new RuntimeException("Invalid Username or Password");
    }
}