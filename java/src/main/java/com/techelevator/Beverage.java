package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends VendingMachineItem{
    public Beverage(String name, BigDecimal price, String id) {
        super(name, price, id);
    }

    @Override
    public String getSound() {
        return "Glug Glug, Yum!";
    }
}
