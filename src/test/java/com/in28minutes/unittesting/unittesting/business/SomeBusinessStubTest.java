package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3};
    }
}

class SomeBusinessStubTest {

    private SomeBusinessImpl someBusiness;

    @BeforeEach
    void setUp() {
        someBusiness = new SomeBusinessImpl();
        someBusiness.setSomeDataService(new SomeDataServiceStub());
    }

    @Test
    void calculateSumUsingDataService_basic() {
        int actualResult = someBusiness.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);

    }
}
