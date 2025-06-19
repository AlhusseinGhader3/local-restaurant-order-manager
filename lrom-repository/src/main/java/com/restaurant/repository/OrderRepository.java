
package com.restaurant.repository;

import com.restaurant.model.Order;
import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}
