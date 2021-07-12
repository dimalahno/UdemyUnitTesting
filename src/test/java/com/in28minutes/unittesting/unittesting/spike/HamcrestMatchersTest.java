package com.in28minutes.unittesting.unittesting.spike;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItem(12));
        assertThat(numbers, hasItems(15, 45));
        assertThat(numbers, hasItems(greaterThan(10)));
        assertThat(numbers, hasItems(lessThan(50)));

        assertThat("", blankOrNullString());
        assertThat("ABCDE", containsString("BCD"));
        assertThat("ABCDE", startsWith("ABC"));
        assertThat("ABCDE", endsWith("CDE"));
    }
}
