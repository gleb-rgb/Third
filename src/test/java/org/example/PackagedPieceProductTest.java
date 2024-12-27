package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PackagedPieceProductTest {

    private ProductPack productPack;
    private PackagedPieceProduct packagedPieceProduct;

    @BeforeEach
    void setUp() {
        productPack = new ProductPack("Коробка", 1.0);
        packagedPieceProduct = new PackagedPieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 2.0, 5, productPack);
    }

    @Test
    void testGetWeightNetto() {
        double expectedWeightNetto = 2.0 * 5;
        assertEquals(expectedWeightNetto, packagedPieceProduct.getWeightNetto(), "Масса нетто должна быть равна 10.0");
    }

    @Test
    void testGetWeightBrutto() {
        double expectedWeightBrutto = packagedPieceProduct.getWeightNetto() + productPack.getMass();
        assertEquals(expectedWeightBrutto, packagedPieceProduct.getWeightBrutto(), "Масса брутто должна быть равна 11.0");
    }

    @Test
    void testEquals() {
        PackagedPieceProduct anotherPackagedPieceProduct = new PackagedPieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 2.0, 5, productPack);
        assertEquals(packagedPieceProduct, anotherPackagedPieceProduct);
    }

    @Test
    void testNotEquals() {
        PackagedPieceProduct differentPackagedPieceProduct = new PackagedPieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 2.0, 10, productPack);
        assertNotEquals(packagedPieceProduct, differentPackagedPieceProduct);
    }

    @Test
    void testHashCode() {
        PackagedPieceProduct anotherPackagedPieceProduct = new PackagedPieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 2.0, 5, productPack);
        assertEquals(packagedPieceProduct.hashCode(), anotherPackagedPieceProduct.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "Масса нетто:10.0Масса брутто:11.0";
        assertEquals(expectedString, packagedPieceProduct.toString());
    }
}