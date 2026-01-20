package com.example.ecommerce.service.order;

import com.example.ecommerce.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    Order createOrder(Order order);

    Optional<Order> getOrderById(Long id);

    List<Order> getAllOrders();

    List<Order> getOrderByUserId(Long userId);
}
