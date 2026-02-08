package com.restaurant.model;

public class Order {
    private String customerName;
    private String dishName;
    private int quantity;
    private boolean isTakeaway;

    public Order(String customerName, String dishName, int quantity, boolean isTakeaway) {
        this.customerName = customerName;
        this.dishName = dishName;
        this.quantity = quantity;
        this.isTakeaway = isTakeaway;
    }

    @Override
    public String toString() {
        return "Order for " + customerName + ": " + quantity + "x " + dishName + (isTakeaway ? " (Takeaway)" : " (Eat-in)");
    }
}