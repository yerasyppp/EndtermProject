package com.restaurant.controller;

import com.restaurant.dto.MenuItemRequest;
import com.restaurant.model.MenuItem;
import com.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuController {
    @Autowired
    private RestaurantService service;

    @GetMapping("/menu")
    public List<MenuItem> getMenu() {
        return service.getAllItems();
    }

    @PostMapping("/menu/add")
    public MenuItem addItem(@RequestBody MenuItemRequest req) {
        return service.addItem(req.getType(), req.getName(), req.getPrice(), req.getExtraParam());
    }

    @DeleteMapping("/menu/{id}")
    public void deleteItem(@PathVariable int id) {
        service.deleteItem(id);
    }

    @GetMapping("/demo-builder")
    public String demoBuilder() {
        return service.createDemoOrder();
    }
}