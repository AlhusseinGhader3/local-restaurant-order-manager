
package com.restaurant.service;

import com.restaurant.model.Reservation;
import com.restaurant.model.Table;
import com.restaurant.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        Table table = new Table(1, 4);
        Reservation reservation = new Reservation("Ali", 2, LocalDateTime.now(), table);
        reservationService.createReservation(reservation);
        verify(reservationRepository, times(1)).save(reservation);
    }

    @Test
    public void testGetAllReservations() {
        Table table = new Table(2, 6);
        List<Reservation> reservations = Arrays.asList(
            new Reservation("Ali", 2, LocalDateTime.now(), table),
            new Reservation("Sara", 4, LocalDateTime.now().plusHours(1), table)
        );
        when(reservationRepository.findAll()).thenReturn(reservations);
        List<Reservation> result = reservationService.getAllReservations();
        assertEquals(2, result.size());
    }
}
