package com.example.ecommerce.dto.user;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String role,
        String address,
        String phone
) { }
