package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
    List<String> mock;

    @BeforeEach
    void setUp() {
        mock = mock(List.class);
    }

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));
        assertEquals("in28Minutes", mock.get(1));
    }

    @Test
    public void verificationBasic() {
        // SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        // Verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        // SUT
        mock.add("SomeString");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        // SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    public void mocking() {
        var arrayListMock = mock(ArrayList.class);

        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        System.out.println(arrayListMock.add("Test"));
        System.out.println(arrayListMock.add("Test2"));
        System.out.println(arrayListMock.size()); // 0

        when(arrayListMock.size()).thenReturn(5);

        System.out.println(arrayListMock.size()); // 5
    }

    @Test
    public void spying() {
        var arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        System.out.println(arrayListSpy.get(0)); // Test0
        System.out.println(arrayListSpy.size()); //
        arrayListSpy.add("Test1");
        System.out.println(arrayListSpy.size()); // 0

        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.add("Test2");

        System.out.println(arrayListSpy.size()); // 5

        verify(arrayListSpy).add("Test2");
    }
}
