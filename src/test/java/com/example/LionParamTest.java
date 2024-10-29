package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParamTest {
    private String sex; // Объявляем переменную пола
    private boolean doesHaveMane; // Объявляем переменную наличия гривы

    /**
     * Констурктор класса
     * @param sex пол
     * @param doesHaveMane наличие гривы
     * @throws Exception ошибка
     */
    public LionParamTest(String sex, boolean doesHaveMane) throws Exception {
        this.sex = sex; // Присваиваем значения пола
        this.doesHaveMane = doesHaveMane; // Присваиваем наличие гривы
    }

    @Parameterized.Parameters
    public static Object[][] getDate(){
        return new Object[][] {
                {"Самец",true},
                {"Самка",false}
        };
    }

    /**
     * Тест на наличие гривы
     * @throws Exception ошибка
     */
    @Test
    public void testDoesHaveMane() throws Exception{
        Lion lion = new Lion(sex, new Feline()); // Создаем экземпляр класса Lion
        Assert.assertEquals(doesHaveMane, lion.doesHaveMane()); // Сравниваем ожидаемое значение с фактическим
    }
}