package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductPackTest {

    ProductPack pack;

    @BeforeEach
    void setUp(){
         pack = new ProductPack("Коробка", 10);
    }
    @Test
    void getName() {
        assertEquals("Коробка", pack.getName());
    }

    @Test
    void setName(){
        assertThrows(IllegalArgumentException.class, () -> pack.setName(""));
    }

    @Test
    void getMass() {
        assertEquals(10, pack.getMass());
    }

    @Test
    void setMass(){
       assertThrows(IllegalArgumentException.class,() -> pack.setMass(-10));
       assertThrows(IllegalArgumentException.class,() -> pack.setMass(0));
    }

    @Test
    void equals(){
        ProductPack pack2 = new ProductPack("Коробка", 10);
        ProductPack pack3 = new ProductPack("Пакет", 0.5);

        assertEquals(pack,pack2);
        assertNotEquals(pack,pack3);
    }

    @Test
    void hashcode(){
        ProductPack pack2 = new ProductPack("Коробка", 10);
        ProductPack pack3 = new ProductPack("Пакет", 0.5);

        assertEquals(pack,pack2);
        assertNotEquals(pack,pack3);
    }

    @Test
    void testToString() {
        String expected = "Название: 'Коробка'  Масса: '10.0'";
        assertEquals(expected,pack.toString());
    }

    @Test
    void testToString1(){
       assertThrows(IllegalArgumentException.class, ()-> new ProductPack("Пакет", -10));
    }
}