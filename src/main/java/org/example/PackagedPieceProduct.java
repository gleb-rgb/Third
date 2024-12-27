package org.example;
import java.util.Objects;

class PackagedPieceProduct extends PieceProduct {
    private final int quantity;
    private final ProductPack product;

    public PackagedPieceProduct(String name, String description, double weightPerPiece, int quantity, ProductPack product) {
        super(name, description, weightPerPiece);
        this.quantity = quantity;
        this.product = product;
    }

    public double getWeightNetto() {
        return getWeightPerPiece() * quantity;
    }

    public int getQuantity() throws IllegalArgumentException{
        if (quantity<=0){
            throw new IllegalArgumentException();
        }
        return quantity;
    }

    public double getWeightBrutto() {
        return getWeightNetto() + product.getMass();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PackagedPieceProduct that = (PackagedPieceProduct) o;
        return quantity == that.quantity && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quantity, product);
    }

    @Override
    public String toString() {
        return "Масса нетто:" + getWeightNetto() + "Масса брутто:" + getWeightBrutto();
    }
}