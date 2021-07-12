package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SomeBusinessTest {

    private SomeBusinessImpl someBusiness;

    @BeforeEach
    void setUp() {
        someBusiness = new SomeBusinessImpl();
    }

    @Test
    void calculateSum() {

        int actualResult = someBusiness.calculateSum(new int[] {1, 2, 3});
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void calculateSum_empty() {

        int actualResult = someBusiness.calculateSum(new int[] {});
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);

    }

    @Test
    void calculateSum_oneValue() {

        int actualResult = someBusiness.calculateSum(new int[] {5});
        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);

    }
}
