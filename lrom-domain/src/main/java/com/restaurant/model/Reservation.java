
package com.restaurant.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private String customerName;
    private int numberOfPeople;
    private LocalDateTime reservationTime;
    private Table table;
    private List<Order> orders = new ArrayList<>();

    public Reservation(String customerName, int numberOfPeople, LocalDateTime reservationTime, Table table) {
        this.customerName = customerName;
        this.numberOfPeople = numberOfPeople;
        this.reservationTime = reservationTime;
        this.table = table;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public Table getTable() {
        return table;
    }
}
