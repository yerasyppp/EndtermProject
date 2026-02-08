package com.restaurant.patterns;

import com.restaurant.model.DrinkItem;
import com.restaurant.model.FoodItem;
import com.restaurant.model.MenuItem;

public class MenuItemFactory {
    public static MenuItem createItem(String type, String name, double price, int extraInfo) {
        if ("FOOD".equalsIgnoreCase(type)) {
            return new FoodItem(name, price, extraInfo);
        } else if ("DRINK".equalsIgnoreCase(type)) {
            return new DrinkItem(name, price, extraInfo);
        } else {
            throw new IllegalArgumentException("Unknown item type");
        }
    }
}