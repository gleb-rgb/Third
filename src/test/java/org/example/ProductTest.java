package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;

    @BeforeEach
    void setUp(){
        product = new Product("Мороженное", "Мороженное 'Золотой стандарт'");
    }

    @Test
    void getNameProduct() {
        assertEquals("Мороженное", product.getNameProduct());
    }

    @Test
    void setNameProduct() {
        assertThrows(IllegalArgumentException.class, ()->product.setNameProduct(""));
    }

    @Test
    void getDescription() {
        assertEquals("'Мороженное золотой стандарт'", product.getDescription());
    }

    @Test
    void setDescription() {
        assertThrows(IllegalArgumentException.class, ()-> product.setDescription(""));
    }

    @Test
    void testEquals() {
        Product product1 = new Product("Мороженное", "Мороженное 'Золотой стандарт'");
        Product product2 = new Product("Сгущенка", "Сгущенка 'Любинская'");

        assertEquals(product,product1);
        assertNotEquals(product,product2);
    }

    @Test
    void testHashCode() {
        Product product1 = new Product("Мороженное", "Мороженное 'Золотой стандарт'");
        Product product2 = new Product("Сгущенка", "Сгущенка 'Любинская'");

        assertEquals(product,product1);
        assertNotEquals(product,product2);
    }

    @Test
    void testToString() {

    }
}