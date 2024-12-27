package org.example;

import java.util.Objects;

public class ProductPack {
    String namePack;
    double mass;

    public ProductPack(String namePack, double mass) {
       setMass(mass);
       setName(namePack);
    }

    public String getName() throws IllegalArgumentException {
            return namePack;
    }

    public void setName(String namePack){
        if (namePack.isEmpty()){
            throw new IllegalArgumentException();
        }
        else {
            this.namePack = namePack;
        }
    }


    public double getMass() {
        return mass;
    }

    public void setMass(double mass) throws IllegalArgumentException{
        if(mass<=0){
            throw new IllegalArgumentException();
        }
        else {
            this.mass = mass;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPack pack1 = (ProductPack) o;
        return Objects.equals(namePack, pack1.namePack) && mass == pack1.mass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(namePack ,mass);
    }

    @Override
    public String toString() {
        if(mass<=0 || namePack.isEmpty()){
            throw new IllegalArgumentException("Ошибка!!");
        }
        else {
            return "Название: '" + namePack + "'  " + "Масса: '" + mass + "'";
        }
    }
}
