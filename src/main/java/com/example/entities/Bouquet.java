package com.example.entities;

import com.example.entities.flowers.Flower;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Bouquet implements Serializable {
    private List<BouquetComponent> bouquet;

    public Bouquet() {
        this.bouquet = new ArrayList<>();
    }

    public Bouquet(List<BouquetComponent> bouquet) {
        this.bouquet = bouquet;
    }

    public List<BouquetComponent> getBouquet() {
        return bouquet;
    }

    public void setBouquet(List<BouquetComponent> bouquet) {
        this.bouquet = bouquet;
    }

    public void addBouquetComponent(BouquetComponent bouquetComponent){
        bouquet.add(bouquetComponent);
    }

    public List<Flower> getFlowersSortedByFreshness(){
        return bouquet.stream()
                .filter(o -> o instanceof Flower)
                .map(o -> (Flower) o)
                .sorted(Comparator.comparingInt(o -> o.getFreshness().ordinal()))
                .collect(Collectors.toList());
    }

    public Flower getMaxByStemLengthFlower(){
        return bouquet.stream()
                .filter(o -> o instanceof Flower)
                .map(o -> (Flower) o)
                .max(Comparator.comparingInt((Flower::getStemLength))).orElse(null);
    }

    public double getCost() {
        return bouquet.stream().mapToDouble(BouquetComponent::getCost).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bouquet bouquet1 = (Bouquet) o;
        return Objects.equals(bouquet, bouquet1.bouquet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bouquet);
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "bouquet=" + bouquet +
                '}';
    }
}
