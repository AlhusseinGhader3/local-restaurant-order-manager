
package com.restaurant.model;

import java.time.Duration;

public class Order {
    private String itemName;
    private Duration preparationTime;

    public Order(String itemName, Duration preparationTime) {
        this.itemName = itemName;
        this.preparationTime = preparationTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Duration getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Duration preparationTime) {
        this.preparationTime = preparationTime;
    }
}
