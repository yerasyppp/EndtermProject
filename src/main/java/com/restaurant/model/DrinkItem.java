package com.restaurant.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
@DiscriminatorValue("DRINK")
public class DrinkItem extends MenuItem {
    @Column(name = "volume_ml")
    private int volumeMl;

    public DrinkItem() {}

    public DrinkItem(String name, double price, int volumeMl) {
        super(name, price);
        this.volumeMl = volumeMl;
    }

    @Override
    public String getType() { return "DRINK"; }

    public int getVolumeMl() { return volumeMl; }
    public void setVolumeMl(int volumeMl) { this.volumeMl = volumeMl; }
}