package com.example.ecommerce.utils.mapper;

import com.example.ecommerce.dto.user.UserResponseDTO;
import com.example.ecommerce.model.User;

public class UserMapper {

    public static User toEntity (User user) {
        if (user == null) return null;

        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole() != null ? user.getRole() : null)
                .address(user.getAddress())
                .phone(user.getPhone())
                .build();
    }

    public static UserResponseDTO toDto(User user) {
        if (user == null) return null;

        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole() != null ? user.getRole().getName() : null)
                .address(user.getAddress())
                .phone(user.getPhone() != null ? String.valueOf(user.getPhone()) : null)
                .build();
    }
}
