package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class GoodsBatchTest {

    private GoodsBatch goodsBatch;
    private PackagedWeight packagedWeight1;
    private PackagedWeight packagedWeight2;

    @BeforeEach
    void setUp() {
        packagedWeight1 = new PackagedWeight("Мороженное", "Мороженное 'Золотой стандарт'", new ProductPack("Коробка", 1), 5);
        packagedWeight2 = new PackagedWeight("Сгущенка", "Сгущенка 'Любинская'", new ProductPack("Банка", 2), 3);

        goodsBatch = new GoodsBatch("Партия 1", List.of(packagedWeight1, packagedWeight2));
    }

    @Test
    void testConstructor() {
        assertNotNull(goodsBatch);
        assertEquals("Партия 1", goodsBatch.getDescription());
        assertEquals(2, goodsBatch.getGoods().size());
    }

    @Test
    void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new GoodsBatch("", List.of(packagedWeight1, packagedWeight2)));
    }

    @Test
    void testInvalidGoodsList() {
        assertThrows(IllegalArgumentException.class, () -> new GoodsBatch("Партия 2", List.of()));
    }

    @Test
    void testGetTotalWeight() {
        double expectedTotalWeight = packagedWeight1.getWeightBrutto() + packagedWeight2.getWeightBrutto();
        assertEquals(expectedTotalWeight, goodsBatch.getTotalWeight());
    }

    @Test
    void testToString() {
        String expectedString = "Партия 1, Масса Партии:" + goodsBatch.getTotalWeight();
        assertEquals(expectedString, goodsBatch.toString());
    }

    @Test
    void testGetDescription() {
        assertEquals("Партия 1", goodsBatch.getDescription());
    }

    @Test
    void testGetGoods() {
        List<PackagedWeight> goodsList = goodsBatch.getGoods();
        assertEquals(2, goodsList.size());
        assertTrue(goodsList.contains(packagedWeight1));
        assertTrue(goodsList.contains(packagedWeight2));
    }
}
