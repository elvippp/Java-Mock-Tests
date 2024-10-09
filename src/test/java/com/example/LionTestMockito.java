package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTestMockito {

    @Mock
    Feline feline;

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(lion.getKittens()).thenReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        // Мок объекта: когда вызывается метод getFood("Хищник"), возвращать список с "Мясо"
        feline.getFood("Хищник");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        // Получаем результат работы метода getFood() класса Lion, проверяем его
        List<String> food = lion.getFood();
        Assert.assertEquals(List.of("Мясо"), food);
    }

    @Test(expected = Exception.class)
    public void exceptionForInvalidSex() throws Exception {
        // Передаём некорректное значение для пола, чтобы вызвать исключение
        Feline feline = new Feline();
        Lion lion = new Lion("Неизвестно", feline);
    }
}