package org.example;
import java.util.Objects;

class PieceProduct extends Product {
    private final double weightPerPiece;

    public PieceProduct(String name, String description, double weightPerPiece) {
        super(name, description);
        this.weightPerPiece = weightPerPiece;
    }

    public double getWeightPerPiece() throws IllegalArgumentException {
        if(weightPerPiece<=0){
            throw new IllegalArgumentException();
        }
        else {
            return weightPerPiece;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PieceProduct that = (PieceProduct) o;
        return Double.compare(that.weightPerPiece, weightPerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weightPerPiece);
    }

    @Override
    public String toString() {
        return super.toString() + ", Вес одной штуки=" + weightPerPiece;
    }
}