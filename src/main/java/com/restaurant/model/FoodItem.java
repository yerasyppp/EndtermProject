package com.restaurant.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FOOD")
public class FoodItem extends MenuItem {
    private int calories;

    public FoodItem() {}

    public FoodItem(String name, double price, int calories) {
        super(name, price);
        this.calories = calories;
    }

    @Override
    public String getType() { return "FOOD"; }

    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }
}