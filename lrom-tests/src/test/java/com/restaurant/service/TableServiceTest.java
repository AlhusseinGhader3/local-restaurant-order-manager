
package com.restaurant.service;

import com.restaurant.model.Table;
import com.restaurant.repository.TableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TableServiceTest {

    private TableRepository tableRepository;
    private TableService tableService;

    @BeforeEach
    public void setUp() {
        tableRepository = Mockito.mock(TableRepository.class);
        tableService = new TableService(tableRepository);
    }

    @Test
    public void testAddTable() {
        Table table = new Table(1, 4);
        tableService.addTable(table);
        verify(tableRepository, times(1)).save(table);
    }

    @Test
    public void testAddTable_NullTable_ShouldThrowException() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            tableService.addTable(null);
        });
        assertEquals("Table cannot be null", exception.getMessage());
    }

    @Test
    public void testGetAllTables() {
        when(tableRepository.findAll()).thenReturn(Collections.emptyList());
        List<Table> tables = tableService.getAllTables();
        assertNotNull(tables);
        assertEquals(0, tables.size());
    }

}
