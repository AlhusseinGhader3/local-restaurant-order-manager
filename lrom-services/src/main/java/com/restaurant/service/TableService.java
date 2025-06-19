package com.restaurant.service;

import com.restaurant.model.Table;
import com.restaurant.repository.TableRepository;

import java.util.List;
import java.util.Objects;

public class TableService {

    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public void addTable(Table table) {
        Objects.requireNonNull(table, "Table cannot be null");
        tableRepository.save(table);
    }

    public List<Table> getAllTables() {
        return tableRepository.findAll();
    }
}
