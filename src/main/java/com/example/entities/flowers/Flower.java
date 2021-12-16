package com.example.entities.flowers;

import com.example.entities.BouquetComponent;

import java.util.Objects;

public class Flower extends BouquetComponent {
    private String name;
    private int stemLength;
    private Freshness freshness;
    private double price;

    public Flower() {
    }

    public Flower(String name, int stemLength, Freshness freshness, double price) {
        this.name = name;
        this.stemLength = stemLength;
        this.freshness = freshness;
        this.price = price;
    }

    @Override
    public double getCost() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        this.stemLength = stemLength;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    public void setFreshness(Freshness freshness) {
        this.freshness = freshness;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return stemLength == flower.stemLength && Double.compare(flower.price, price) == 0 && name.equals(flower.name) && freshness == flower.freshness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stemLength, freshness, price);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", stemLength=" + stemLength +
                ", freshness=" + freshness +
                ", price=" + price +
                "}";
    }
}
