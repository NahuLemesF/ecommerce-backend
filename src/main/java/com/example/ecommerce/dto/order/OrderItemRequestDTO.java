package com.example.ecommerce.dto.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderItemRequestDTO(
        @NotNull(message = "Product id is required")
        Long productId,

        @NotNull
        @Min(value = 1, message = "Quantity must be at least 1")
        Integer quantity

) {}
