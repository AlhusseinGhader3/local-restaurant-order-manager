
package com.restaurant.repository;

import com.restaurant.model.Table;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTableRepository implements TableRepository {
    private List<Table> tables = new ArrayList<>();

    @Override
    public void save(Table table) {
        tables.add(table);
    }

    @Override
    public List<Table> findAll() {
        return tables;
    }
}
