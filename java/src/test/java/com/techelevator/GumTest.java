package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class GumTest {


    @Test
    public void gumSoundIsChewChewYumYum(){
        //ARRANGE
        Gum item = new Gum("Pringles",new BigDecimal("5.00"),"A2");
        //ACT
        String actual = item.getSound();
        String expected = "Chew Chew, Yum!";
        //ASSERT
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void gumIsMaxQtyOnLoad(){
        //ARRANGE
        Gum item = new Gum("Pringles",new BigDecimal("5.00"),"A2");
        //ACT
        int actual = item.getStock();
        int expected = 5;
        //ASSERT
        Assert.assertEquals(expected, actual);
    }
}
