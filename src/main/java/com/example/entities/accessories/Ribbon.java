package com.example.entities.accessories;

import com.example.entities.BouquetComponent;

import java.util.Objects;

public class Ribbon extends BouquetComponent {
    private Colour colour;
    private double length;
    private double pricePerMeter;

    public Ribbon() {
    }

    public Ribbon(Colour colour, double length, double pricePerMeter) {
        this.colour = colour;
        this.length = length;
        this.pricePerMeter = pricePerMeter;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPricePerMeter() {
        return pricePerMeter;
    }

    public void setPricePerMeter(double pricePerMeter) {
        this.pricePerMeter = pricePerMeter;
    }

    @Override
    public double getCost() {
        return Math.round(length * pricePerMeter * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ribbon ribbon = (Ribbon) o;
        return Double.compare(ribbon.length, length) == 0 && Double.compare(ribbon.pricePerMeter, pricePerMeter) == 0 && colour == ribbon.colour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, length, pricePerMeter);
    }

    @Override
    public String toString() {
        return "Ribbon{" +
                "colour=" + colour +
                ", length=" + length +
                ", pricePerMeter=" + pricePerMeter +
                '}';
    }
}
