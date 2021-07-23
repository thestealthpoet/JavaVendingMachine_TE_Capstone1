package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CandyTest {


    @Test
    public void candySoundIsGlugGlugYum(){
        //ARRANGE
        Candy item = new Candy("Kit Kat",new BigDecimal("1.00"),"A2");
        //ACT
        String actual = item.getSound();
        String expected = "Munch Munch, Yum!";
        //ASSERT
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void candyIsMaxQtyOnLoad(){
        //ARRANGE
        Candy item = new Candy("Kit Kat",new BigDecimal("1.00"),"A2");
        //ACT
        int actual = item.getStock();
        int expected = 5;
        //ASSERT
        Assert.assertEquals(expected, actual);
    }
}
