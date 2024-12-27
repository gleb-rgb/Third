package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeightedProductTest {

    private WeightedProduct weightedProduct;

    @BeforeEach
    void setUp() {
        weightedProduct = new WeightedProduct("Молоко", "Молоко 'Загорье'", 10.0);
    }

    @Test
    void testGetWeightProduct() {
        assertEquals(10.0, weightedProduct.getWeightProduct(), "Вес продукта должен быть 10.0");
    }

    @Test
    void testInvalidWeight() {
        WeightedProduct invalidProduct = new WeightedProduct("Молоко", "Молоко 'Загорье'", 0.0);
        assertThrows(IllegalArgumentException.class, invalidProduct::getWeightProduct, "Вес не может быть нулевым или отрицательным");

        invalidProduct = new WeightedProduct("Молоко", "Молоко 'Загорье'", -5.0);
        assertThrows(IllegalArgumentException.class, invalidProduct::getWeightProduct, "Вес не может быть нулевым или отрицательным");
    }

    @Test
    void testToString() {
        String expectedString = "Название продукта: 'Молоко'  Описание: Молоко 'Загорье', Weight: 10.0";
        assertEquals(expectedString, weightedProduct.toString(), "Метод toString должен возвращать правильную строку");
    }
}
