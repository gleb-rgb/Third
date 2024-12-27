package org.example;

import java.util.Objects;

class PackagedWeight extends WeightedProduct {
    private final ProductPack product;

    public PackagedWeight(String name, String description, ProductPack product, double weightProduct) {
        super(name, description, weightProduct);
        this.product = product;
    }

    public double getWeightsNetto() {
        return getWeightProduct();
    }

    public double getWeightBrutto() {
        return getWeightProduct() + product.getMass();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackagedWeight that = (PackagedWeight) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), product.getMass());
    }

    @Override
    public String toString() {
        return "Масса нетто:" + getWeightsNetto()+ "  " + "Масса брутто:" + getWeightBrutto();
    }
}

