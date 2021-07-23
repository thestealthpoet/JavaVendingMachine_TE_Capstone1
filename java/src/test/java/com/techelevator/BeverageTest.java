package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BeverageTest {



    @Test
    public void beverageSoundIsGlugGlugYum(){
        //ARRANGE
        Beverage beverage = new Beverage("Water",new BigDecimal("1.00"),"A2");
        //ACT
        String actual = beverage.getSound();
        String expected = "Glug Glug, Yum!";
        //ASSERT
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void beverageIsMaxQtyOnLoad(){
        //ARRANGE
        Beverage beverage = new Beverage("Water",new BigDecimal("1.00"),"B2");
        //ACT
        int actual = beverage.getStock();
        int expected = 5;
        //ASSERT
        Assert.assertEquals(expected, actual);
    }
}
