package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    /**
     * Тест животного на травоядное
     *
     * @throws Exception ошибка
     */
    @Test
    public void getFoodHerbivores() throws Exception {
        // Создаем экземпляр Animal
        Animal animal = new Animal();
        // Запрашиваем еду для травоядного животного
        List<String> food = animal.getFood("Травоядное");
        // Сравниваем полученный и ожидаемый результат
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    /**
     * Тест на хищника
     *
     * @throws Exception ошибка
     */
    @Test
    public void getFoodPredators() throws Exception {
        // Создаем экземпляр Animal
        Animal animal = new Animal();
        // Запрашиваем еду для хищного животного
        List<String> food = animal.getFood("Хищник");
        // Сравниваем полученный и ожидаемый результат
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    /**
     * Тест нна некорректную еду для животного
     *
     * @throws Exception ошибка
     */
    @Test
    public void getFoodUnKnown() throws Exception {
        // Создаем экземпляр Animal
        Animal animal = new Animal();
        // Проверяем что при запросе еды для неизвестного типа животного выдается исключение
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестно");
        });
        // Проверяем что сообщение об ошибке соответствует ожидаемому
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    /**
     * Тест на семейство
     */
    @Test
    public void getFamily() {
        // Создаем экземпляр Animal
        Animal animal = new Animal();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}