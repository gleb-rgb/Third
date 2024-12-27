package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContainsStringFilterTest {

    @Test
    void testMatchingSubstring() {
        Filter filter = new ContainsStringFilter("Золотой");

        assertTrue(filter.apply("Мороженное 'Золотой стандарт'"));
    }

    @Test
    void testNonMatchingSubstring() {
        Filter filter = new ContainsStringFilter("Золотой");

        assertFalse(filter.apply("Сгущенка"));
    }

    @Test
    void testEmptyString() {
        Filter filter = new ContainsStringFilter("Золотой");

        assertFalse(filter.apply(""));
    }

    @Test
    void testNullPattern() {
        assertThrows(IllegalArgumentException.class, () -> new ContainsStringFilter(null));
    }

    @Test
    void testEmptyPattern() {
        assertThrows(IllegalArgumentException.class, () -> new ContainsStringFilter(""));
    }

    @Test
    void testExactMatch() {
        Filter filter = new ContainsStringFilter("Сгущенка");

        assertTrue(filter.apply("Сгущенка"));
    }
}
