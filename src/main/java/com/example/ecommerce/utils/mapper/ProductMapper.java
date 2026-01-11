package com.example.ecommerce.utils.mapper;

import com.example.ecommerce.dto.product.ProductRequestDTO;
import com.example.ecommerce.dto.product.ProductResponseDTO;
import com.example.ecommerce.model.Product;

import java.time.LocalDateTime;

public class ProductMapper {

    public static Product toEntity (ProductRequestDTO dto) {
        if (dto == null) return null;

        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .imageUrl(dto.getImageUrl())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ProductResponseDTO toDto(Product product) {
        if (product == null) return null;

        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .imageUrl(product.getImageUrl())
                .createdAt(product.getCreatedAt())
                .build();
    }
}
