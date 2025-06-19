
package com.restaurant.model;

import java.time.Duration;
import java.util.List;

public class CookingScheduler {
    public static Duration calculateTotalPreparationTime(List<Order> orders) {
        return orders.stream()
                     .map(Order::getPreparationTime)
                     .reduce(Duration.ZERO, Duration::plus);
    }
}
