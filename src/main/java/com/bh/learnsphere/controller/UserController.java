package com.bh.learnsphere.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/api/me")
    public Object me(@AuthenticationPrincipal UserDetails user) {
        return user != null ? user.getUsername() : "anonymous";
    }
}
