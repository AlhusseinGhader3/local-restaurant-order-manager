package com.restaurant.service;

import com.restaurant.model.Table;
import com.restaurant.repository.TableRepository;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TableServiceNegativeTest {

    @Test
    public void testGetAllTables_WhenEmpty() {
        TableRepository mockRepo = mock(TableRepository.class);
        when(mockRepo.findAll()).thenReturn(Collections.emptyList());

        TableService service = new TableService(mockRepo);
        List<Table> result = service.getAllTables();

        assertTrue(result.isEmpty(), "Expected empty list when no tables exist");
    }

    @Test
    public void testAddNullTable_ShouldThrowException() {
        TableRepository mockRepo = mock(TableRepository.class);
        TableService service = new TableService(mockRepo);

        assertThrows(NullPointerException.class, () -> service.addTable(null));
    }
}