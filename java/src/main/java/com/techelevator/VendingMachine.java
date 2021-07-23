package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private List<VendingMachineItem> inventory = new ArrayList<>();
    BigDecimal balance = new BigDecimal("0.00");

    public VendingMachine() {
        stockVendingMachine();
    }

    public List<VendingMachineItem> stockVendingMachine() {
        File inventoryInput = new File("vendingmachine.csv");
        try {
            Scanner scanner = new Scanner(inventoryInput);
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");

                String id = parts[0];
                String name = parts[1];
                BigDecimal price = new BigDecimal(parts[2]);
                String type = parts[3].toLowerCase();

                switch(type) {
                    case "candy":
                        inventory.add(new Candy(name, price, id));
                        break;
                    case "chips":
                        inventory.add(new Chips(name, price, id));
                        break;
                    case "gum":
                        inventory.add(new Gum(name, price, id));
                        break;
                    case "beverage":
                        inventory.add(new Beverage(name, price, id));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found.");
        }
        return inventory;
    }

    public List<VendingMachineItem> getInventory() {
        return inventory;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal addMoney(BigDecimal amountToAdd) {
        balance = balance.add(amountToAdd);
        return balance;
    }

    public BigDecimal subtractMoney(BigDecimal amountToSubtract){
        balance = balance.subtract(amountToSubtract);
        return balance;
    }


    public void dispenseChange(){
        final BigDecimal QUARTER = new BigDecimal("0.25");
        final BigDecimal DIME = new BigDecimal("0.10");
        final BigDecimal NICKEL = new BigDecimal("0.05");

//        String change = "";
//        BigDecimal numOfQuarters =balance.divide(QUARTER);
//        change += numOfQuarters + " QUARTERS ";
//
//        amountToRemove = amountToRemove.multiply(QUARTER);
//        balance.subtract(amountToRemove);
//
//        amountToRemove = balance.divide(DIME);
//        change += amountToRemove + " DIMES ";
//
//        amountToRemove = amountToRemove.multiply(DIME);
//        balance = balance.subtract(amountToRemove);
//
//        amountToRemove = balance.divide(NICKEL);
//        change += amountToRemove + " NICKELS ";
//
//        amountToRemove = amountToRemove.multiply(NICKEL);
//        balance = balance.subtract(amountToRemove);

       // return change;

    }
}
