package com.restaurant.ui;

import com.restaurant.model.MenuItem;
import com.restaurant.model.Order;
import com.restaurant.model.Reservation;
import com.restaurant.model.Table;
import com.restaurant.repository.InMemoryMenuItemRepository;
import com.restaurant.repository.InMemoryOrderRepository;
import com.restaurant.repository.InMemoryReservationRepository;
import com.restaurant.repository.InMemoryTableRepository;
import com.restaurant.repository.MenuItemRepository;
import com.restaurant.repository.OrderRepository;
import com.restaurant.repository.ReservationRepository;
import com.restaurant.repository.TableRepository;
import com.restaurant.service.MenuItemService;
import com.restaurant.service.OrderService;
import com.restaurant.service.ReservationService;
import com.restaurant.service.TableService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class RestaurantUI extends JFrame {

    private final ReservationService reservationService;
    private final OrderService orderService;
    private final MenuItemService menuItemService;
    private final TableService tableService;

    public RestaurantUI() {
        // إعداد المستودعات في الذاكرة
        ReservationRepository reservationRepository = new InMemoryReservationRepository();
        OrderRepository orderRepository = new InMemoryOrderRepository();
        MenuItemRepository menuItemRepository = new InMemoryMenuItemRepository();
        TableRepository tableRepository = new InMemoryTableRepository();

        // إعداد الخدمات
        reservationService = new ReservationService(reservationRepository);
        orderService = new OrderService(orderRepository);
        menuItemService = new MenuItemService(menuItemRepository);
        tableService = new TableService(tableRepository);

        initializeUI();
    }

    private void initializeUI() {
        setTitle("Local Restaurant Order Manager");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JButton reservationButton = new JButton("Create Reservation");
        JButton menuButton = new JButton("Add Menu Item");
        JButton orderButton = new JButton("Add Order to Reservation");

        reservationButton.addActionListener(this::createReservation);
        menuButton.addActionListener(this::addMenuItem);
        orderButton.addActionListener(this::addOrder);

        add(reservationButton);
        add(menuButton);
        add(orderButton);
    }

    private void createReservation(ActionEvent e) {
        Table table = new Table(1, 4);
        tableService.addTable(table);

        Reservation reservation = new Reservation("John Doe", 2, LocalDateTime.now(), table);
        reservationService.createReservation(reservation);

        JOptionPane.showMessageDialog(this, "Reservation Created Successfully!");
    }

    private void addMenuItem(ActionEvent e) {
        MenuItem item = new MenuItem("Pizza", BigDecimal.valueOf(12.5), Duration.ofMinutes(15));
        menuItemService.addMenuItem(item);
        JOptionPane.showMessageDialog(this, "Menu Item Added Successfully!");
    }

    private void addOrder(ActionEvent e) {
        Order order = new Order("Pizza", Duration.ofMinutes(15));
        orderService.createOrder(order);
        JOptionPane.showMessageDialog(this, "Order Added Successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RestaurantUI().setVisible(true));
    }
}
