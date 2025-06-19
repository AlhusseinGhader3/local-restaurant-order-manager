
package com.restaurant.service;

import com.restaurant.model.MenuItem;
import com.restaurant.repository.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        MenuItem item = new MenuItem("Pizza", BigDecimal.valueOf(15), Duration.ofMinutes(20));
        menuItemService.addMenuItem(item);
        verify(menuItemRepository, times(1)).save(item);
    }

    @Test
    public void testGetAllMenuItems() {
        when(menuItemRepository.findAll()).thenReturn(Collections.emptyList());
        List<MenuItem> items = menuItemService.getAllMenuItems();
        assertNotNull(items);
        assertEquals(0, items.size());
    }
}
