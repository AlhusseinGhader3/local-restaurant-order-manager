
package com.restaurant.repository;

import com.restaurant.model.MenuItem;
import java.util.List;

public interface MenuItemRepository {
    void save(MenuItem item);
    List<MenuItem> findAll();
}
