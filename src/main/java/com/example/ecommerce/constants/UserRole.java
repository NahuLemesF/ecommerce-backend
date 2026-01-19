package com.example.ecommerce.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum UserRole {
    CLIENT("client"),
    ADMIN("admin");

    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

}