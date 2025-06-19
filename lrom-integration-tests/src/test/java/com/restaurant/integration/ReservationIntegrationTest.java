
package com.restaurant.integration;

import com.restaurant.model.MenuItem;
import com.restaurant.model.Reservation;
import com.restaurant.model.Table;
import com.restaurant.repository.InMemoryMenuItemRepository;
import com.restaurant.repository.InMemoryReservationRepository;
import com.restaurant.service.MenuItemService;
import com.restaurant.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class ReservationIntegrationTest {

    // مثال بسيط بدون ربط حقيقي بالـ DB الآن لتسهيل الفهم أولاً
    private ReservationService reservationService;
    private MenuItemService menuItemService;

    @BeforeEach
    public void setUp() {
        reservationService = new ReservationService(new InMemoryReservationRepository());
        menuItemService = new MenuItemService(new InMemoryMenuItemRepository());
    }

    @Test
    public void testReservationAndMenuIntegration() {
        Table table = new Table(1, 4);
        Reservation reservation = new Reservation("Bob", 3, LocalDateTime.now(), table);
        reservationService.createReservation(reservation);

        MenuItem item = new MenuItem("Steak", BigDecimal.valueOf(25), Duration.ofMinutes(30));
        menuItemService.addMenuItem(item);

        List<Reservation> reservations = reservationService.getAllReservations();
        List<MenuItem> items = menuItemService.getAllMenuItems();

        assertEquals(1, reservations.size());
        assertEquals(1, items.size());
        assertEquals("Steak", items.get(0).getName());
    }
}
