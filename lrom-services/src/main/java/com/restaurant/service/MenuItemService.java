package com.restaurant.service;

import com.restaurant.model.MenuItem;
import com.restaurant.repository.MenuItemRepository;

import java.util.List;
import java.util.Objects;

public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public void addMenuItem(MenuItem item) {
        Objects.requireNonNull(item, "MenuItem cannot be null");
        menuItemRepository.save(item);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }
}
