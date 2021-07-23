package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void StockVendingMachine() {
        VendingMachine vm = new VendingMachine();
        Assert.assertTrue(vm.getInventory().size() > 0);
    }

    @Test
    public void addMoneyTest() {
        VendingMachine vm = new VendingMachine();
        BigDecimal expected = new BigDecimal("5.00");
        BigDecimal actual = vm.addMoney(new BigDecimal("5.00"));
        Assert.assertEquals(expected.compareTo(actual), 0);
    }

    @Test
    public void subtractMoneyTest() {
        VendingMachine vm = new VendingMachine();
        BigDecimal expected = new BigDecimal("-5.00");
        BigDecimal actual = vm.subtractMoney(new BigDecimal("5.00"));
        Assert.assertEquals(expected.compareTo(actual), 0);
    }

    @Test
    public void testGetBalance() {
        VendingMachine vm = new VendingMachine();
        BigDecimal expected = new BigDecimal("0.00");
        BigDecimal actual = vm.getBalance();
        Assert.assertEquals(expected.compareTo(actual), 0);
    }

    @Test
    public void testDispenseChange() {
        VendingMachine vm = new VendingMachine();
        String expected = "0 quarters, 0 dimes, 0 nickels is your change.";
        String actual = vm.dispenseChange();
        Assert.assertEquals(expected, actual);

    }

}