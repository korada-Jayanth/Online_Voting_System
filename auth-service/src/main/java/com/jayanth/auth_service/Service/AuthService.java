package com.jayanth.auth_service.Service;

import com.jayanth.auth_service.DTO.LoginRequest;
import com.jayanth.auth_service.DTO.RegisterRequest;
import com.jayanth.auth_service.Repository.UserRepository;
import com.jayanth.auth_service.Util.JWTUtil;
import com.jayanth.auth_service.model.Role;
import com.jayanth.auth_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil jwtUti;


    public String register(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequest request) {

        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if(user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        if(!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUti.generateToken(user.get().getEmail());
    }


}
