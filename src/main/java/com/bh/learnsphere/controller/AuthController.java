package com.bh.learnsphere.controller;

import com.bh.learnsphere.dto.AuthRequest;
import com.bh.learnsphere.dto.AuthResponse;
import com.bh.learnsphere.dto.RegisterRequest;
import com.bh.learnsphere.entity.Role;
import com.bh.learnsphere.entity.User;
import com.bh.learnsphere.repository.UserRepository;
import com.bh.learnsphere.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository,
                          PasswordEncoder passwordEncoder,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            return ResponseEntity.badRequest().body("Email is already taken");
        }

        Set<Role> roles = new HashSet<>();
        try {
            if (req.getRole() != null) {
                roles.add(Role.valueOf(req.getRole()));
            } else {
                roles.add(Role.ROLE_STUDENT);
            }
        } catch (Exception ex) {
            // invalid role string -> fallback to student
            roles.add(Role.ROLE_STUDENT);
        }

        User u = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .roles(roles)
                .build();

        userRepository.save(u);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest req) {
        var authToken = new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword());
        authenticationManager.authenticate(authToken);

        var userOpt = userRepository.findByEmail(req.getEmail()).orElseThrow();
        var token = jwtUtil.generateToken(userOpt);

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
