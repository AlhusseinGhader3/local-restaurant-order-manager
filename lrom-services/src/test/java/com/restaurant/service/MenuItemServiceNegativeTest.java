package com.restaurant.service;

import com.restaurant.model.MenuItem;
import com.restaurant.repository.MenuItemRepository;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuItemServiceNegativeTest {

    @Test
    public void testGetAllMenuItems_WhenEmpty() {
        MenuItemRepository mockRepo = mock(MenuItemRepository.class);
        when(mockRepo.findAll()).thenReturn(Collections.emptyList());

        MenuItemService service = new MenuItemService(mockRepo);
        List<MenuItem> result = service.getAllMenuItems();

        assertTrue(result.isEmpty(), "Expected empty list when no menu items");
    }

    @Test
    public void testAddNullMenuItem_ShouldThrowException() {
        MenuItemRepository mockRepo = mock(MenuItemRepository.class);
        MenuItemService service = new MenuItemService(mockRepo);

        assertThrows(NullPointerException.class, () -> service.addMenuItem(null));
    }
}