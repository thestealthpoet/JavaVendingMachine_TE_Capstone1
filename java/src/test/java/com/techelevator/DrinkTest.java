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
}
