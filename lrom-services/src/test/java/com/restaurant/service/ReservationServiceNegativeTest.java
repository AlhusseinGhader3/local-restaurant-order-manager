package com.restaurant.service;

import com.restaurant.model.Reservation;
import com.restaurant.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservationServiceNegativeTest {

    @Test
    public void testGetAllReservations_WhenNoneExist() {
        ReservationRepository mockRepo = mock(ReservationRepository.class);
        when(mockRepo.findAll()).thenReturn(Collections.emptyList());

        ReservationService service = new ReservationService(mockRepo);
        List<Reservation> result = service.getAllReservations();

        assertTrue(result.isEmpty(), "Expected no reservations");
    }

    @Test
    public void testCreateReservation_WithNull_ShouldThrow() {
        ReservationRepository mockRepo = mock(ReservationRepository.class);
        ReservationService service = new ReservationService(mockRepo);

        assertThrows(NullPointerException.class, () -> service.createReservation(null));
    }
}