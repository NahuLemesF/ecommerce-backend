package com.example.ecommerce.service.order;

import com.example.ecommerce.dto.order.OrderItemRequestDTO;
import com.example.ecommerce.model.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    Order createOrder(Long userId, List<OrderItemRequestDTO> items);

    Optional<Order> getOrderById(Long id);

    List<Order> getAllOrders();

    List<Order> getOrderByUserId(Long userId);
}
