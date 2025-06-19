
package com.restaurant.model;

import java.math.BigDecimal;
import java.util.List;

public class Invoice {
    private Reservation reservation;
    private BigDecimal totalAmount;

    public Invoice(Reservation reservation, BigDecimal totalAmount) {
        this.reservation = reservation;
        this.totalAmount = totalAmount;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
