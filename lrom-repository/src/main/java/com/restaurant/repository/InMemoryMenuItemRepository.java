
package com.restaurant.repository;

import com.restaurant.model.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class InMemoryMenuItemRepository implements MenuItemRepository {
    private List<MenuItem> menuItems = new ArrayList<>();

    @Override
    public void save(MenuItem item) {
        menuItems.add(item);
    }

    @Override
    public List<MenuItem> findAll() {
        return menuItems;
    }
}
