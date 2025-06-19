
package com.restaurant.service;

import com.restaurant.model.Order;
import com.restaurant.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        Order order = new Order("Burger", Duration.ofMinutes(10));
        orderService.createOrder(order);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testGetAllOrders() {
        when(orderRepository.findAll()).thenReturn(Collections.emptyList());
        List<Order> orders = orderService.getAllOrders();
        assertNotNull(orders);
        assertEquals(0, orders.size());
    }

    @Test
    public void testCreateOrder_NullOrder_ShouldThrowException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            orderService.createOrder(null);
        });
        assertEquals("Order cannot be null", exception.getMessage());
    }

}
