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
public class LionTest {
    Feline feline = new Feline();

    @Test
    //проверяем кол-во котят для Lion
    public void getKittensResultOne() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    //проверяем, что генерится Исключение и отображается нужный текст Исключения для конструктора Lion
    public void checkTextOfExceptionInConstructorLion() throws Exception {
        try {
            Lion lion = new Lion("Самeец", feline);
            Assert.fail("Ожидалось исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }


    @Mock
    Feline felineMock;

    //проверяем,что еда для Lion - еда Хищника
    @Test
    public void getFoodResultForPredator() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = lion.getFood();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    // проверяем, что при вызове getFood() вызываеся метод с аргуемнтом "Хищник"
    public void checkStartGetFoodWithArgumentPredator() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        lion.getFood();
        Mockito.verify(felineMock).getFood("Хищник");
    }

    @Test
    // проверяем, что при вызове etKittens() вызываеся метод без аргументов
    public void checkStartGetKittensWithoutArguments() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        lion.getKittens();
        Mockito.verify(felineMock).getKittens();
    }
}