package com.restaurant.service;

import com.restaurant.model.Order;
import com.restaurant.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceNegativeTest {

    @Test
    public void testGetAllOrders_WhenNoneExist() {
        OrderRepository mockRepo = mock(OrderRepository.class);
        when(mockRepo.findAll()).thenReturn(Collections.emptyList());

        OrderService service = new OrderService(mockRepo);
        List<Order> result = service.getAllOrders();

        assertEquals(0, result.size(), "Should return empty list when no orders found");
    }

    @Test
    public void testCreateOrder_WithNull_ShouldThrow() {
        OrderRepository mockRepo = mock(OrderRepository.class);
        OrderService service = new OrderService(mockRepo);

        assertThrows(NullPointerException.class, () -> service.createOrder(null));
    }
}