package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipsTest {


    @Test
    public void chipSoundIsCrunchCrunchYum(){
        //ARRANGE
        Chips item = new Chips("Pringles",new BigDecimal("5.00"),"A2");
        //ACT
        String actual = item.getSound();
        String expected = "Crunch Crunch, Yum!";
        //ASSERT
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void chipIsMaxQtyOnLoad(){
        //ARRANGE
        Chips item = new Chips("Pringles",new BigDecimal("5.00"),"A2");
        //ACT
        int actual = item.getStock();
        int expected = 5;
        //ASSERT
        Assert.assertEquals(expected, actual);
    }
}
