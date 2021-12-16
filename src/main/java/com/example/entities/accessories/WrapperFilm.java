package com.example.entities.accessories;

import com.example.entities.BouquetComponent;

import java.util.Objects;

public class WrapperFilm extends BouquetComponent {
    private Colour colour;
    private double width;
    private double length;
    private double priceForSquareMeter;

    public WrapperFilm() {
    }

    public WrapperFilm(Colour colour, double width, double length, double priceForSquareMeter) {
        this.colour = colour;
        this.width = width;
        this.length = length;
        this.priceForSquareMeter = priceForSquareMeter;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getPriceForSquareMeter() {
        return priceForSquareMeter;
    }

    public void setPriceForSquareMeter(double priceForSquareMeter) {
        this.priceForSquareMeter = priceForSquareMeter;
    }

    @Override
    public double getCost() {
        return Math.round(width * length * priceForSquareMeter * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperFilm that = (WrapperFilm) o;
        return Double.compare(that.width, width) == 0 && Double.compare(that.length, length) == 0 && Double.compare(that.priceForSquareMeter, priceForSquareMeter) == 0 && colour == that.colour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, width, length, priceForSquareMeter);
    }

    @Override
    public String toString() {
        return "WrapperFilm{" +
                "colour=" + colour +
                ", width=" + width +
                ", length=" + length +
                ", priceForSquareMeter=" + priceForSquareMeter +
                '}';
    }
}
