package com.bh.learnsphere.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    // optional: ROLE_STUDENT | ROLE_INSTRUCTOR | ROLE_ADMIN
    private String role;
}
