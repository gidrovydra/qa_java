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
public class CatTest {

    @Test
    //проверяем, что Cat издает звук Мяу
    public void getSoundResultMeow() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }


    @Mock
    Feline feline;

    //проверяем, что еда для Cat - это еда хищника
    @Test
    public void getFoodResultForPredator() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = cat.getFood();
        assertEquals(expectedResult,actualResult);
    }

}