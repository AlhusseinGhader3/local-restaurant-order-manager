
package com.restaurant.repository;

import com.restaurant.model.Order;
import java.util.ArrayList;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}
