package org.example;

class GoodsService {

    public static long countByFilter(GoodsBatch batch, Filter filter) {
        return batch.getGoods().stream()
                .filter(good -> filter.apply(good.getNameProduct()) || filter.apply(good.getDescription()))
                .count();
    }
}
