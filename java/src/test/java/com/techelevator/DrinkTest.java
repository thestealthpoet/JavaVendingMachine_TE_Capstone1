package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DrinkTest {



    @Test
    public void drinkSoundIsGlugGlugYum(){
        //ARRANGE
        Drink drink = new Drink("Water",new BigDecimal("1.00"),"A2");
        //ACT
        String actual = drink.getSound();
        String expected = "Glug Glug, Yum!";
        //ASSERT
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void drinkIsMaxQtyOnLoad(){
        //ARRANGE
        Drink drink = new Drink("Water",new BigDecimal("1.00"),"B2");
        //ACT
        int actual = drink.getStock();
        int expected = 5;
        //ASSERT
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drinkA2IdReturnsA2Id() {
        Drink drink = new Drink("Water", new BigDecimal("1.00"),"A2");

        String actual = drink.getId();
        String expected = "A2";

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void drinkWaterNameReturnsWaterName() {
        Drink drink = new Drink("Water", new BigDecimal("1.00"),"A2");

        String actual = drink.getName();
        String expected = "Water";

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void drink1DollarPriceReturns1DollarPrice() {
        Drink drink = new Drink("Water", new BigDecimal("1.00"),"A2");

        BigDecimal actual = drink.getPrice();
        BigDecimal expected = new BigDecimal("1.00");

        Assert.assertEquals(expected.compareTo(actual), 0);
    }

    @Test
    public void testIsSoldOutIsTrueWhenStockIs0() {
        Drink drink = new Drink("Water", new BigDecimal("1.00"),"A2");
        for(int i = 0; i < 5; i++) {
            drink.reduceStock();
        }

        boolean expected = true;
        boolean actual = drink.isSoldOut();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsSoldOutIsFalseWhenStockIs1() {
        Drink drink = new Drink("Water", new BigDecimal("1.00"),"A2");
        for(int i = 0; i < 4; i++) {
            drink.reduceStock();
        }

        boolean expected = false;
        boolean actual = drink.isSoldOut();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReduceStockWhenNotSoldOutShouldReturnTrue() {
        Drink drink = new Drink("Water", new BigDecimal("1.00"),"A2");

        boolean expected = true;
        boolean actual = drink.reduceStock();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReduceStockWhenSoldOutShouldReturnFalse() {
        Drink drink = new Drink("Water", new BigDecimal("1.00"),"A2");
        for(int i = 0; i < 5; i++) {
            drink.reduceStock();
        }

        boolean expected = false;
        boolean actual = drink.reduceStock();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringShouldReturnCorrectly() {
        Drink drink = new Drink("Water", new BigDecimal("1.00"),"A2");

        String expected = "A2 Water 1.00";
        String actual = drink.toString();

        Assert.assertEquals(expected, actual);
    }
}
