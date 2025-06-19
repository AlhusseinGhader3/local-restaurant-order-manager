
package com.restaurant.service;

import com.restaurant.model.Order;
import com.restaurant.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    private OrderRepository orderRepository;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        orderRepository = Mockito.mock(OrderRepository.class);
        orderService = new OrderService(orderRepository);
    }

    @Test
    public void testCreateOrder() {
        Order order = new Order("Ali", Duration.ofMinutes(30));
        orderService.createOrder(order);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testGetAllOrders() {
        List<Order> orders = Arrays.asList(
            new Order("Ali", Duration.ofMinutes(20)),
            new Order("Sara", Duration.ofMinutes(25))
        );
        when(orderRepository.findAll()).thenReturn(orders);
        List<Order> result = orderService.getAllOrders();
        assertEquals(2, result.size());
    }
}
