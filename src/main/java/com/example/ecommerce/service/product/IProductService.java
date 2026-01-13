package com.example.ecommerce.service.product;

import com.example.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    Product createProduct(Product product);

    Optional<Product> getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
