package com.techelevator;

import java.math.BigDecimal;

public abstract class VendingMachineItem {

    private String name;
    private BigDecimal price;
    private String id;
    private int stock = 5;
    
    public VendingMachineItem(String name, BigDecimal price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract String getSound();

}
