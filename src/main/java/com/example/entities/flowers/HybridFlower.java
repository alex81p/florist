package com.example.entities.flowers;

import java.util.Objects;

public class HybridFlower extends Flower{
    private Colour colour;

    public HybridFlower() {
    }

    public HybridFlower(String name, int stemLength, Freshness freshness, double price, Colour colour) {
        super(name, stemLength, freshness, price);
        this.colour = colour;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HybridFlower that = (HybridFlower) o;
        return colour == that.colour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), colour);
    }

    @Override
    public String toString() {
        return "HybridFlower{" +
                "colour=" + colour +
                "} " + super.toString();
    }
}
