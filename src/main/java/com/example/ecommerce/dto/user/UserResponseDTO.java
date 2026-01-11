package com.example.ecommerce.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String role;
    private String address;
    private String phone;
}
