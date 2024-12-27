package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EndsWithStringFilterTest {

    @Test
    void testMatchingSuffix() {
        Filter filter = new EndsWithStringFilter("Стандарт'");

        assertTrue(filter.apply("Мороженное 'Золотой Стандарт'"));
    }

    @Test
    void testNonMatchingSuffix() {
        Filter filter = new EndsWithStringFilter("Стандарт");

        assertFalse(filter.apply("Сгущенка"));
    }

    @Test
    void testEmptyString() {
        Filter filter = new EndsWithStringFilter("Стандарт");

        assertFalse(filter.apply(""));
    }

    @Test
    void testNullPattern() {
        assertThrows(IllegalArgumentException.class, () -> new EndsWithStringFilter(null));
    }

    @Test
    void testEmptyPattern() {
        assertThrows(IllegalArgumentException.class, () -> new EndsWithStringFilter(""));
    }

    @Test
    void testExactMatch() {
        Filter filter = new EndsWithStringFilter("Сгущенка");

        assertTrue(filter.apply("Сгущенка"));
    }
}
