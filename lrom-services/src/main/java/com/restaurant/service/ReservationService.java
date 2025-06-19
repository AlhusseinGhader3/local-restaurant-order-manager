package com.restaurant.service;

import com.restaurant.model.Reservation;
import com.restaurant.repository.ReservationRepository;

import java.util.List;
import java.util.Objects;

public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(Reservation reservation) {
        Objects.requireNonNull(reservation, "Reservation cannot be null");
        reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
