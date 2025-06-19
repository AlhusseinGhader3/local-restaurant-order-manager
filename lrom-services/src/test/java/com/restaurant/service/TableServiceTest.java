
package com.restaurant.service;

import com.restaurant.model.Table;
import com.restaurant.repository.TableRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void testGetAllTables() {
        List<Table> tables = Arrays.asList(
            new Table(1, 4),
            new Table(2, 6)
        );
        when(tableRepository.findAll()).thenReturn(tables);
        List<Table> result = tableService.getAllTables();
        assertEquals(2, result.size());
    }
}
