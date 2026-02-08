package com.restaurant.dto;

public class MenuItemRequest {
    private String name;
    private double price;
    private String type;
    private int extraParam;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getExtraParam() { return extraParam; }
    public void setExtraParam(int extraParam) { this.extraParam = extraParam; }
}