package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class GoodsServiceTest {

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
    void testBeginStringFilter() {
        Filter filter = new BeginStringFilter("Морож");
        long count = GoodsService.countByFilter(goodsBatch, filter);

        assertEquals(1, count);
    }

    @Test
    void testEndsWithStringFilter() {
        Filter filter = new EndsWithStringFilter("Сгущенка 'Любинская'");
        long count = GoodsService.countByFilter(goodsBatch, filter);

        assertEquals(1, count);
    }

    @Test
    void testStringFilter() {
        Filter filter = new ContainsStringFilter("Золотой");
        long count = GoodsService.countByFilter(goodsBatch, filter);

        assertEquals(1, count);
    }

    @Test
    void testNoMatches() {
        Filter filter = new ContainsStringFilter("Кофе");
        long count = GoodsService.countByFilter(goodsBatch, filter);

        assertEquals(0, count);
    }

    @Test
    void testMultipleMatches() {
        PackagedWeight packagedWeight3 = new PackagedWeight("Мороженное", "Мороженное 'Золотой стандарт'", new ProductPack("Пакет", 0.5), 7);
        GoodsBatch extendedGoodsBatch = new GoodsBatch("Партия 2", List.of(packagedWeight1, packagedWeight2, packagedWeight3));

        Filter filter = new BeginStringFilter("Морож");
        long count = GoodsService.countByFilter(extendedGoodsBatch, filter);

        assertEquals(2, count);
    }
}
