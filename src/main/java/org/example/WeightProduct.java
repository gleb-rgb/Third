package org.example;

class WeightedProduct extends Product {
    private final double weightProduct;
    public WeightedProduct(String name, String description, double weightProduct) {
        super(name, description);
        this.weightProduct = weightProduct;
    }

    public double getWeightProduct() throws IllegalArgumentException{
        if(weightProduct<=0){
            throw new IllegalArgumentException();
        }
        else {
            return weightProduct;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Weight: " + weightProduct;
    }
}


