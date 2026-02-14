package com.restaurant.service;

import com.restaurant.model.MenuItem;
import com.restaurant.model.Order;
import com.restaurant.patterns.InMemoryCache;
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
    private final InMemoryCache cache = InMemoryCache.getInstance();
    private final String MENU_CACHE_KEY = "menu_items";

    @Autowired
    public RestaurantService(MenuRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> getAllItems() {
        List<MenuItem> cachedMenu = (List<MenuItem>) cache.get(MENU_CACHE_KEY);
        if (cachedMenu != null) {
            logger.log("Returning menu from Cache (Fast!)");
            return cachedMenu;
        }

        logger.log("Fetching menu from Database (Slow...)");
        List<MenuItem> items = repository.findAll();

        cache.put(MENU_CACHE_KEY, items);
        return items;
    }

    public MenuItem addItem(String type, String name, double price, int extra) {
        MenuItem item = MenuItemFactory.createItem(type, name, price, extra);
        MenuItem savedItem = repository.save(item);

        cache.remove(MENU_CACHE_KEY);
        logger.log("Item added. Cache cleared.");

        return savedItem;
    }

    public void deleteItem(int id) {
        repository.deleteById(id);

        cache.remove(MENU_CACHE_KEY);
        logger.log("Item deleted. Cache cleared.");
    }

    public MenuItem getItemById(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
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