package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionTestParam {
    private String sex;
    private boolean doesHaveMane;

    public LionTestParam(String sex,boolean doesHaveMane) throws Exception {
        this.sex = sex;
        this.doesHaveMane = doesHaveMane;
    }

    @Parameterized.Parameters
    public static Object[][] getDate(){
        return new Object[][] {
                {"Самец",true},
                {"Самка",false}
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception{
        Lion lion = new Lion(sex,new Feline());
        Assert.assertEquals(doesHaveMane, lion.doesHaveMane());
    }
}