package com.example.ecommerce.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponseDTO(
        Long orderId,
        Long userId,
        LocalDateTime createdAt,
        List<OrderItemResponseDTO> items,
        BigDecimal total
) {
}
