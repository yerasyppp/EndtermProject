package com.restaurant.patterns;

import com.restaurant.model.Order;

public class OrderBuilder {
    private String customerName;
    private String dishName;
    private int quantity = 1;
    private boolean isTakeaway = false;

    public OrderBuilder setCustomerName(String name) {
        this.customerName = name;
        return this;
    }

    public OrderBuilder setDishName(String dishName) {
        this.dishName = dishName;
        return this;
    }

    public OrderBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder setTakeaway(boolean isTakeaway) {
        this.isTakeaway = isTakeaway;
        return this;
    }

    public Order build() {
        return new Order(customerName, dishName, quantity, isTakeaway);
    }
}