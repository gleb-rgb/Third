package org.example;
import java.util.List;
import java.util.ArrayList;

class GoodsBatch {
    private String description;
    private List<PackagedWeight> goods;

    public GoodsBatch(String description, List<PackagedWeight> goods) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (goods == null || goods.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.description = description;
        this.goods = new ArrayList<>(goods);
    }

    public String getDescription() {
        return description;
    }

    public List<PackagedWeight> getGoods() {
        return goods;
    }

    public double getTotalWeight() {
        return goods.stream().mapToDouble(PackagedWeight::getWeightBrutto).sum();
    }

    @Override
    public String toString() {
        return description + ", Масса Партии:" + getTotalWeight();
    }
}
