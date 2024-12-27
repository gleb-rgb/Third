package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PieceProductTest {

    private PieceProduct pieceProduct;

    @BeforeEach
    void setUp() {
        pieceProduct = new PieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 2.0);
    }

    @Test
    void testGetWeightPerPiece() {
        assertEquals(2.0, pieceProduct.getWeightPerPiece());
    }

    @Test
    void testInvalidWeight() {
        PieceProduct invalidProduct = new PieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 0.0);
        assertThrows(IllegalArgumentException.class, invalidProduct::getWeightPerPiece);

        invalidProduct = new PieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", -1.0);
        assertThrows(IllegalArgumentException.class, invalidProduct::getWeightPerPiece);
    }

    @Test
    void testEquals() {
        PieceProduct anotherPieceProduct = new PieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 2.0);
        assertEquals(pieceProduct, anotherPieceProduct);
    }

    @Test
    void testNotEquals() {
        PieceProduct differentPieceProduct = new PieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 3.0);
        assertNotEquals(pieceProduct, differentPieceProduct);
    }

    @Test
    void testHashCode() {
        PieceProduct anotherPieceProduct = new PieceProduct("Мороженное", "Мороженное 'Золотой стандарт'", 2.0);
        assertEquals(pieceProduct.hashCode(), anotherPieceProduct.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "Название продукта: 'Мороженное'  Описание: Мороженное 'Золотой стандарт', Вес одной штуки=2.0";
        assertEquals(expectedString, pieceProduct.toString());
    }
}
