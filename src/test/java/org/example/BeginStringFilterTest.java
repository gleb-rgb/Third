package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BeginStringFilterTest {

    @Test
    void testMatchingPrefix() {

        Filter filter = new BeginStringFilter("Морож");

        assertTrue(filter.apply("Мороженное"));
    }

    @Test
    void testNonMatchingPrefix() {
        Filter filter = new BeginStringFilter("Морож");

        assertFalse(filter.apply("Сгущенка"));
    }

    @Test
    void testEmptyString() {

        Filter filter = new BeginStringFilter("Морож");

        assertFalse(filter.apply(""));
    }

    @Test
    void testNullPattern() {
        assertThrows(IllegalArgumentException.class, () -> new BeginStringFilter(null));
    }

    @Test
    void testEmptyPattern() {
        assertThrows(IllegalArgumentException.class, () -> new BeginStringFilter(""));
    }

    @Test
    void testExactMatch() {
        Filter filter = new BeginStringFilter("Сгущенка");

        assertTrue(filter.apply("Сгущенка"));
    }
}
