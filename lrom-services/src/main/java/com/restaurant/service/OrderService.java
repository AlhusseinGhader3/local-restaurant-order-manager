package com.restaurant.service;

import com.restaurant.model.Order;
import com.restaurant.repository.OrderRepository;

import java.util.List;
import java.util.Objects;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createOrder(Order order) {
        Objects.requireNonNull(order, "Order cannot be null");
        orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
