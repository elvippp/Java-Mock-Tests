package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class AlexTest {
    private Alex alex; // Объявили переменную для класса Alex
    private Feline feline; // Объявили переменную для класса Feline

    @Before
    public void init() throws Exception {
        feline = Mockito.mock(Feline.class); // Создали мок для класса Feline
        alex = new Alex(feline); // Инициализируем объект alex
    }

    @Test
    public void getFriends() {
        // Получаем имена друзей Алекса
        List<String> friends = alex.getFriends();
        // Проверяем, что имена друзей совпадают с ожидаемым результатом
        assertEquals(List.of("Марти", "Глории", "Мелман"), friends);
    }

    @Test
    public void getPlaceOfLiving() {
        // Проверяем, что место жилья совпадает с ожидаемым результатом
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittens() {
        // Настраиваем мок объект, чтобы возвращал 0
        Mockito.when(feline.getKittens()).thenReturn(0);
        // Проверяем, что возвращаемое количество котят было 0
        assertEquals(0, alex.getKittens());
    }
}