package com.example.ecommerce.dto.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderRequestDTO(
        @NotNull(message = "User id is required")
        Long userId,

        @NotEmpty(message = "Order must have at least one item")
        List<OrderItemRequestDTO> items
) {
}
