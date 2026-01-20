package com.example.ecommerce.service.order;

import com.example.ecommerce.dto.order.OrderItemRequestDTO;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderItem;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.IOrderItemRepository;
import com.example.ecommerce.repository.IOrderRepository;
import com.example.ecommerce.repository.IProductRepository;
import com.example.ecommerce.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IOrderItemRepository orderItemRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;

    public OrderServiceImpl(IOrderRepository orderRepository, IOrderItemRepository orderItemRepository, IUserRepository userRepository, IProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public Order createOrder(Long userId, List<OrderItemRequestDTO> items) {

        if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        if (items == null || items.isEmpty()) {
            throw new RuntimeException("Order must contain at least one item");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();
        order.setUser(user);

        for (OrderItemRequestDTO itemDTO : items) {
            Product product = productRepository.findById(itemDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            Integer requestedQuantity = itemDTO.quantity();
            if (requestedQuantity > product.getStock()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(requestedQuantity);
            orderItem.setPriceAtPurchase(product.getPrice());
            order.getItems().add(orderItem);

            product.setStock(product.getStock() - requestedQuantity);
        }
        return orderRepository.save(order);

    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrderByUserId(Long userId) {
        return orderRepository.findByUserId(userId);

    }
}
