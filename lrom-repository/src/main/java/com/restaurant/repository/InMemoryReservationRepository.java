
package com.restaurant.repository;

import com.restaurant.model.Reservation;
import java.util.ArrayList;
import java.util.List;

public class InMemoryReservationRepository implements ReservationRepository {
    private List<Reservation> reservations = new ArrayList<>();

    @Override
    public void save(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return reservations;
    }
}
