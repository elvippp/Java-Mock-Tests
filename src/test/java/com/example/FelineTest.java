package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
public class FelineTest {

    @Test
    public void eatMeat() throws Exception{
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),food);
    }

    @Test
    public void toGetFamily(){
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи",feline.getFamily());
    }

    @Test
    public void toGetKitten() {
        Feline feline = new Feline();
        Assert.assertEquals(1,feline.getKittens());
    }

    @Test
    public void toGetKittens() {
        Feline feline = new Feline();
        Assert.assertEquals(4,feline.getKittens(4));
    }
}