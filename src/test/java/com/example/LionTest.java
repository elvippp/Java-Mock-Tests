package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Feline feline; // Объявляем переменную класса Feline
    private Lion lion; // Объявляем переменную класса Lion

    @Before
    public void init() throws Exception {
        feline = Mockito.mock(Feline.class); // Создаем мок объект для класса Feline
        lion = new Lion("Самка", feline); // Создаем экземпляр класса Lion
    }

    /**
     * Тест на получение 1 котенка
     */
    @Test
    public void getKittens(){
        // Настраиваем мок объект, чтобы он возвращал 1 котенка
        Mockito.when(feline.getKittens()).thenReturn(1);
        // Проверяем, что метод возвращает 1
        Assert.assertEquals(1, lion.getKittens());
    }

    /**
     * Тест на проверку гривы
     * @throws Exception ошибка
     */
    @Test
    public void doesHaveMane() throws Exception {
        // Проверяем, что у самки нет гривы
        assertFalse(lion.doesHaveMane());
    }

    /**
     * Тест на вид еды
     * @throws Exception ошибка
     */
    @Test
    public void getFood() throws Exception {
        // Мок объекта: когда вызывается метод getFood("Хищник"), возвращать список с "Мясо"
        feline.getFood("Хищник");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        // Получаем результат работы метода getFood() класса Lion, проверяем его
        List<String> food = lion.getFood();
        Assert.assertEquals(List.of("Мясо"), food);
    }

    /**
     * Тест на получение ошибки при не корректном поле животного
     */
    @Test
    public void shouldThrowExceptionForInvalidSex() {
        Feline feline = new Feline();
        // Проверяем, что при передаче некорректного значения пола будет выброшено исключение
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", feline);
        });
        // Проверяем, что сообщение исключения соответствует ожидаемому
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}