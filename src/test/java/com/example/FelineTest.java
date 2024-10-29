package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
public class FelineTest {

    /**
     * Тест на виды мяса
     * @throws Exception ошибка
     */
    @Test
    public void eatMeat() throws Exception{
        // Создаем экземпляр класса Feline
        Feline feline = new Feline();
        // Получаем список еды
        List<String> food = feline.eatMeat();
        // Проверяем, что список еды совпадает с ожидаемым результатом
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),food);
    }

    /**
     * Тест на принадлежность семейству
     */
    @Test
    public void toGetFamily(){
        // Создаем экземпляр класса Feline
        Feline feline = new Feline();
        // Проверяем, что название семейства совпадает с ожидаемым результатом
        Assert.assertEquals("Кошачьи",feline.getFamily());
    }

    /**
     * Тест на получение 1 котенка
     */
    @Test
    public void toGetKitten() {
        // Создаем экземпляр класса Feline
        Feline feline = new Feline();
        // Проверяем, что метод возвращает 1
        Assert.assertEquals(1,feline.getKittens());
    }

    /**
     * Тест на получение котят
     */
    @Test
    public void toGetKittens() {
        // Создаем экземпляр класса Feline
        Feline feline = new Feline();
        // Проверяем, что метод возвращает ожидаемое количество котят
        Assert.assertEquals(4,feline.getKittens(4));
    }
}