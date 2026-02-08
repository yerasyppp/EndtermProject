package com.restaurant.service;

import com.restaurant.model.MenuItem;
import com.restaurant.model.Order;
import com.restaurant.patterns.MenuItemFactory;
import com.restaurant.patterns.OrderBuilder;
import com.restaurant.patterns.SingletonLogger;
import com.restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final MenuRepository repository;
    private final SingletonLogger logger = SingletonLogger.getInstance();

    @Autowired
    public RestaurantService(MenuRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> getAllItems() {
        logger.log("Getting all items");
        return repository.findAll();
    }

    public MenuItem addItem(String type, String name, double price, int extra) {
        MenuItem item = MenuItemFactory.createItem(type, name, price, extra);
        return repository.save(item);
    }

    public MenuItem getItemById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void deleteItem(int id) {
        repository.deleteById(id);
    }

    public String createDemoOrder() {
        Order order = new OrderBuilder()
                .setCustomerName("Murat")
                .setDishName("Burger")
                .setQuantity(2)
                .setTakeaway(true)
                .build();
        return "Builder Created: " + order.toString();
    }
}