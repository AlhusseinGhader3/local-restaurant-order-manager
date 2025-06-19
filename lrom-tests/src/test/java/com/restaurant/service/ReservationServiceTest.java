
package com.restaurant.service;

import com.restaurant.model.Reservation;
import com.restaurant.model.Table;
import com.restaurant.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservationServiceTest {

    private ReservationRepository reservationRepository;
    private ReservationService reservationService;

    @BeforeEach
    public void setUp() {
        reservationRepository = Mockito.mock(ReservationRepository.class);
        reservationService = new ReservationService(reservationRepository);
    }

    @Test
    public void testCreateReservation() {
        Reservation reservation = new Reservation("Alice", 2, LocalDateTime.now(), new Table(1, 4));
        reservationService.createReservation(reservation);
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    public void testGetAllReservations() {
        when(reservationRepository.findAll()).thenReturn(Collections.emptyList());
        List<Reservation> reservations = reservationService.getAllReservations();
        assertNotNull(reservations);
        assertEquals(0, reservations.size());
    }

    @Test
    public void testCreateReservation_NullReservation_ShouldThrowException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            reservationService.createReservation(null);
        });
        assertEquals("Reservation cannot be null", exception.getMessage());
    }

}
