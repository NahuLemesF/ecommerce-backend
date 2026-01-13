package com.example.ecommerce.config;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.product.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(ProductServiceImpl productService) {
        return args -> {
            if (productService.getAllProducts().isEmpty()) {

                productService.createProduct(Product.builder()
                        .name("Camiseta Rock")
                        .description("Camiseta de algodón con estampado rockero")
                        .price(new BigDecimal("25.99"))
                        .stock(10)
                        .imageUrl("https://example.com/images/camiseta.jpg")
                        .build());

                productService.createProduct(Product.builder()
                        .name("Gorra Vintage")
                        .description("Gorra estilo vintage, color negro")
                        .price(new BigDecimal("15.50"))
                        .stock(20)
                        .imageUrl("https://example.com/images/gorra.jpg")
                        .build());

                productService.createProduct(Product.builder()
                        .name("Auriculares Bluetooth")
                        .description("Auriculares inalámbricos con cancelación de ruido")
                        .price(new BigDecimal("75.00"))
                        .stock(5)
                        .imageUrl("https://example.com/images/auriculares.jpg")
                        .build());

                productService.createProduct(Product.builder()
                        .name("Mochila Urbana")
                        .description("Mochila resistente para uso diario")
                        .price(new BigDecimal("40.00"))
                        .stock(8)
                        .imageUrl("https://example.com/images/mochila.jpg")
                        .build());

                productService.createProduct(Product.builder()
                        .name("Taza Café")
                        .description("Taza de cerámica con diseño divertido")
                        .price(new BigDecimal("9.99"))
                        .stock(50)
                        .imageUrl("https://example.com/images/taza.jpg")
                        .build());
            }
        };
    }
}
