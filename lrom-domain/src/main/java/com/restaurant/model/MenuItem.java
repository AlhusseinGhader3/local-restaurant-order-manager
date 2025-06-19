
package com.restaurant.model;

import java.math.BigDecimal;
import java.time.Duration;

public class MenuItem {
    private String name;
    private BigDecimal price;
    private Duration preparationTime;

    public MenuItem(String name, BigDecimal price, Duration preparationTime) {
        this.name = name;
        this.price = price;
        this.preparationTime = preparationTime;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Duration getPreparationTime() {
        return preparationTime;
    }
}
