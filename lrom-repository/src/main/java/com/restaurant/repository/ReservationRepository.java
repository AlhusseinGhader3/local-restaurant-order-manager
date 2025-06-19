
package com.restaurant.repository;

import com.restaurant.model.Reservation;
import java.util.List;

public interface ReservationRepository {
    void save(Reservation reservation);
    List<Reservation> findAll();
}
