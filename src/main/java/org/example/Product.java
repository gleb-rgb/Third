package org.example;

import java.util.Objects;

public class Product {
    String nameProduct;
    String description;

    public Product(String nameProduct, String description) {
        this.nameProduct = nameProduct;
        this.description = description;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) throws IllegalArgumentException {
        if(nameProduct.isEmpty()){
            throw new IllegalArgumentException();
        }
        else {
            this.nameProduct = nameProduct;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if(description.isEmpty()){
            throw new IllegalArgumentException();
        }
        else {
            this.description = description;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product1 = (Product) o;
        return Objects.equals(nameProduct, product1.nameProduct) && Objects.equals(description, product1.description);
    }

    public int hashCode() {
        return Objects.hash(nameProduct, description);
    }

    @Override
    public String toString() {
        return "Название продукта: '" + nameProduct + "'  " + "Описание: " + description;
    }
}
