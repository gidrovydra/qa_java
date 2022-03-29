package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class LionDifferentGenderParameterizedTest {

    private String gender;
    private boolean expectedResult;

    public LionDifferentGenderParameterizedTest(String gender, boolean expectedResult){
        this.gender = gender;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getGendersOfLion() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    //проверка, что для Самки и Самца получаем соответствующие значения hasMane
    public void  checkGenderForConstructorLion() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(gender, feline);
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals(expectedResult,actualResult);
    }

}
