
package com.restaurant.repository;

import com.restaurant.model.Table;
import java.util.List;

public interface TableRepository {
    void save(Table table);
    List<Table> findAll();
}
