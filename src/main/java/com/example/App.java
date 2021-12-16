package com.example;

import com.example.entities.Bouquet;
import com.example.entities.BouquetComponent;

import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("data/serial.xml")));
        List<BouquetComponent> availableComponents = (ArrayList<BouquetComponent>) xmlDecoder.readObject();
        System.out.println("You have the following list of flowers and accessories:");
        IntStream.range(0, availableComponents.size())
                .forEach(i -> System.out.println((i + 1) + " - " + availableComponents.get(i)));
        List<Integer> chosenBouquetComponents = getListOfIntegersFromConsole(
                "Create a bouquet by entering numbers separated by spaces (numbers can be repeated):",
                o -> o > 0 && o <= availableComponents.size());
        Bouquet bouquet = new Bouquet();
        chosenBouquetComponents.forEach(i -> bouquet.addBouquetComponent(availableComponents.get(i - 1)));
        System.out.println("\nYour bouquet costs $" + bouquet.getCost() + ":");
        bouquet.getBouquet().forEach(System.out::println);
        System.out.println("\nFlowers sorted by freshness:");
        bouquet.getFlowersSortedByFreshness().forEach(System.out::println);
        System.out.println("\nFlower with the longest stem:" + bouquet.getMaxByStemLengthFlower());
    }

    private static List<Integer> getListOfIntegersFromConsole(String question, Predicate<Integer> predicate) {
        boolean inputIsValid = false;
        List<Integer> integers = new ArrayList<>();
        while (!inputIsValid) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(question);
                String string = scanner.nextLine();
                scanner = new Scanner(string);
                while (scanner.hasNextInt()) {
                    integers.add(scanner.nextInt());
                }
                if (!integers.stream().allMatch(predicate)) {
                    throw new Exception();
                }
                inputIsValid = true;
                scanner.close();
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                integers = new ArrayList<>();
            }
        }
        return integers;
    }
}