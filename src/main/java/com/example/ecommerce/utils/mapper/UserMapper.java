package com.example.ecommerce.utils.mapper;

import com.example.ecommerce.dto.user.UserRequestDTO;
import com.example.ecommerce.dto.user.UserResponseDTO;
import com.example.ecommerce.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        if (dto == null) return null;

        return User.builder()
                .name(dto.name())
                .email(dto.email())
                .password(dto.password())
                .role(dto.role())
                .address(dto.address())
                .phone(dto.phone())
                .build();
    }

    public static UserResponseDTO toDto(User user) {
        if (user == null) return null;

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().getName(),
                user.getAddress(),
                user.getPhone()
        );
    }
}
