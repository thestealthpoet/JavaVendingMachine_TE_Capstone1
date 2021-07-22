package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingMachineItem{
    public Chips(String name, BigDecimal price, String id) {
        super(name, price, id);
    }

    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}
