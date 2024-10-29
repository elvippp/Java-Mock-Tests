package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class CatTest {
    private Feline feline; // Объявляем переменную для класса Feline
    private Cat cat; // Объявляем переменную для класса Cat

    /**
     * Инициализация теста
     */
    @Before
    public void init() {
        feline = Mockito.mock(Feline.class); // Создаем мок для класса Feline
        cat = new Cat(feline); // Инициализируем объект Cat
    }

    /**
     * Тест издаивающего звука
     */
    @Test
    public void testSound() {
        // Проверяем, что звук кошки соответствует ожидаемому результату
        Assert.assertEquals("Мяу", cat.getSound());
    }

    /**
     * Тест на еду
     * @throws Exception ошибка
     */
    @Test
    public void testFood() throws Exception {
        // Настраиваем мок объект, чтобы возвращал список с "Мясо"
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        // Получаем еду кошки
        List<String> food = cat.getFood();
        // Проверяем, что возвращаемый список еды совпадает с ожидаемым результатом
        assertEquals(List.of("Мясо"), food);
        // Проверяем, что метод был вызван один раз на мок объекте feline
        Mockito.verify(feline).eatMeat();
    }
}