package com.example.ecommerce.config;

import com.example.ecommerce.constants.UserRole;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.product.ProductServiceImpl;
import com.example.ecommerce.service.user.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(
            ProductServiceImpl productService,
            UserServiceImpl userService
    ) {
        return args -> {

            // -------- PRODUCTS --------
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
            }

            // -------- USERS --------
            if (userService.getAllUsers().isEmpty()) {

                userService.createUser(User.builder()
                        .name("Admin User")
                        .email("admin@ecommerce.com")
                        .password("admin123")
                        .role(UserRole.ADMIN)
                        .address("Admin Street 123")
                        .phone("099123456")
                        .build());

                userService.createUser(User.builder()
                        .name("John Doe")
                        .email("john@ecommerce.com")
                        .password("password123")
                        .role(UserRole.CLIENT)
                        .address("Main St 456")
                        .phone("098111222")
                        .build());

                userService.createUser(User.builder()
                        .name("Jane Smith")
                        .email("jane@ecommerce.com")
                        .password("password123")
                        .role(UserRole.CLIENT)
                        .address("Second Ave 789")
                        .phone("097333444")
                        .build());
            }
        };
    }
}
