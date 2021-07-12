package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {

    /*  SomeBusinessImpl business = new SomeBusinessImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @BeforeEach
    public void before() {
        business.setSomeDataService(dataServiceMock);
    }*/

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    SomeDataService dataServiceMock;

    @Test
    void calculateSumUsingDataService_basic() {

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        assertEquals(6, business.calculateSumUsingDataService());

    }

    @Test
    void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
        assertEquals(5, business.calculateSumUsingDataService());
    }
}
