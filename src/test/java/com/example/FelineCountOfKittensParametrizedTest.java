package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineCountOfKittensParametrizedTest {

    private int countKittens;
    private int expectedResult;

    public FelineCountOfKittensParametrizedTest(int countKittens, int expectedResult) {
        this.countKittens = countKittens;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getCountOfKitten(){
        return new Object[][] {
                {1,1},
                {5,5},
        };
    }

    @Test
    public void getKittensResultSeveralKittens() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens(countKittens);
        assertEquals(expectedResult,actualResult);
    }
}
