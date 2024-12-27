package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PackagedWeightTest {

    private ProductPack productPack;
    private PackagedWeight packagedWeight;

    @BeforeEach
    void setUp() {
        productPack = new ProductPack("Коробка", 1.0);
        packagedWeight = new PackagedWeight("Мороженное", "Мороженное 'Золотой стандарт'", productPack, 5.0);
    }

    @Test
    void testGetWeightsNetto() {
        assertEquals(5.0, packagedWeight.getWeightsNetto());
    }

    @Test
    void testGetWeightBrutto() {
        double expectedWeightBrutto = 5.0 + productPack.getMass();
        assertEquals(expectedWeightBrutto, packagedWeight.getWeightBrutto());
    }

    @Test
    void testEquals() {
        PackagedWeight anotherPackagedWeight = new PackagedWeight("Мороженное", "Мороженное 'Золотой стандарт'", productPack, 5.0);
        assertEquals(packagedWeight, anotherPackagedWeight);
    }

    @Test
    void testNotEquals() {
        PackagedWeight differentPackagedWeight = new PackagedWeight("Сметана", "Мороженное 'Золотой стандарт'", productPack, 10.0);
        assertNotEquals(packagedWeight, differentPackagedWeight);
    }

    @Test
    void testHashCode() {
        PackagedWeight anotherPackagedWeight = new PackagedWeight("Мороженное", "Мороженное 'Золотой стандарт'", productPack, 5.0);
        assertEquals(packagedWeight.hashCode(), anotherPackagedWeight.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "Масса нетто:5.0  Масса брутто:6.0";
        assertEquals(expectedString, packagedWeight.toString());
    }
}
