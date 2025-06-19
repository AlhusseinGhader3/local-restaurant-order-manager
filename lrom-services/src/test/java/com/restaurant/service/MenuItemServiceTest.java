
package com.restaurant.service;

import com.restaurant.model.MenuItem;
import com.restaurant.repository.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MenuItemServiceTest {

    private MenuItemRepository menuItemRepository;
    private MenuItemService menuItemService;

    @BeforeEach
    public void setUp() {
        menuItemRepository = Mockito.mock(MenuItemRepository.class);
        menuItemService = new MenuItemService(menuItemRepository);
    }

    @Test
    public void testAddMenuItem() {
        MenuItem item = new MenuItem("Pizza", new BigDecimal("12.99"), Duration.ofMinutes(20));
        menuItemService.addMenuItem(item);
        verify(menuItemRepository, times(1)).save(item);
    }

    @Test
    public void testGetAllMenuItems() {
        List<MenuItem> items = Arrays.asList(
            new MenuItem("Burger", new BigDecimal("10.50"), Duration.ofMinutes(15)),
            new MenuItem("Pasta", new BigDecimal("11.00"), Duration.ofMinutes(18))
        );
        when(menuItemRepository.findAll()).thenReturn(items);
        List<MenuItem> result = menuItemService.getAllMenuItems();
        assertEquals(2, result.size());
    }
}
