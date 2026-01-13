package com.example.ecommerce.utils.mapper;

import com.example.ecommerce.dto.user.UserRequestDTO;
import com.example.ecommerce.dto.user.UserResponseDTO;
import com.example.ecommerce.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        if (dto == null) return null;

        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .address(dto.getAddress())
                .phone(dto.getPhone() != null ? Integer.valueOf(dto.getPhone()) : null)
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
                .phone(user.getPhone() != null ? user.getPhone().toString() : null)
                .build();
    }
}
