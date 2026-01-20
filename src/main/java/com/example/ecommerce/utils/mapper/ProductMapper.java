package com.example.ecommerce.utils.mapper;

import com.example.ecommerce.dto.product.ProductRequestDTO;
import com.example.ecommerce.dto.product.ProductResponseDTO;
import com.example.ecommerce.model.Product;

public class ProductMapper {

    public static Product toEntity (ProductRequestDTO dto) {
        if (dto == null) return null;

        return Product.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .stock(dto.stock())
                .imageUrl(dto.imageUrl())
                .build();
    }

    public static ProductResponseDTO toDto(Product product) {
        if (product == null) return null;

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getImageUrl(),
                product.getCreatedAt()
        );
    }
}
