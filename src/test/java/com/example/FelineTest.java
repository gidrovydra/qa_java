package com.example;

import org.junit.Test;


import java.util.List;

import static org.junit.Assert.*;


public class FelineTest {

    @Test
    //провеярем, что метод вернет ожидаемый текст
    public void getFamilyResultCatFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    //проверям, что метод getKittens без параметров вернет 1
    public void getKittensResultOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    //проверям, что метод возвращет список еды для Хищника
    public void eatMeatResultForPredator() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Feline feline = new Feline();
        List<String> actualResult = feline.eatMeat();
        assertEquals(expectedResult, actualResult);
    }

}