package com.example.ecommerce.dto.order;

import java.math.BigDecimal;


public record OrderItemResponseDTO(
        Long productId,
        String productName,
        Integer quantity,
        BigDecimal priceAtPurchase,
        BigDecimal subtotal
) {
}
