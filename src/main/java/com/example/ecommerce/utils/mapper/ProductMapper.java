package com.example.ecommerce.utils.mapper;

import com.example.ecommerce.dto.product.ProductRequestDTO;
import com.example.ecommerce.dto.product.ProductResponseDTO;
import com.example.ecommerce.model.Product;

public class ProductMapper {

    public static Product toEntity (ProductRequestDTO dto) {
        if (dto == null) return null;

        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .imageUrl(dto.getImageUrl())
                .build();
    }

    public static ProductResponseDTO toDto(Product product) {
        if (product == null) return null;

        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .stock(product.getStock())
                .imageUrl(product.getImageUrl())
                .createdAt(product.getCreatedAt())
                .build();
    }
}
