package com.jayanth.auth_service.Controller;

import com.jayanth.auth_service.DTO.LoginRequest;
import com.jayanth.auth_service.DTO.RegisterRequest;
import com.jayanth.auth_service.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/validate")
    public String validateToken() {
        return "JWT Token is valid";
    }
}
