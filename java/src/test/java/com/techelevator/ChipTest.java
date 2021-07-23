package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipTest {


    @Test
    public void chipSoundIsCrunchCrunchYum(){
        //ARRANGE
        Chip item = new Chip("Pringles",new BigDecimal("5.00"),"A2");
        //ACT
        String actual = item.getSound();
        String expected = "Crunch Crunch, Yum!";
        //ASSERT
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void chipIsMaxQtyOnLoad(){
        //ARRANGE
        Chip item = new Chip("Pringles",new BigDecimal("5.00"),"A2");
        //ACT
        int actual = item.getStock();
        int expected = 5;
        //ASSERT
        Assert.assertEquals(expected, actual);
    }
}
