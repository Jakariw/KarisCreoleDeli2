package org.example.models;

import org.example.Priceable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich implements Priceable {
    private int size;
    private String breadType;
    private List<Toppings> meats;
    private List<Toppings> cheeses;
    private List<String> regularToppings;
    private List<String> sauces;
    private boolean toasted;
    private double price;

    // Constructor
    public Sandwich(String breadType, int size, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();

        //Methods to set the price based on size
        switch (size) {
            case 4:
                this.price = 5.5;
                break;
            case 12:
                this.price = 7.00;
                break;
            case 18:
                this.price = 8.50;
                break;
            default:
                this .price = 0.0; // Default price if size is not recognized
        }
    }
    //Methods to add toppings with updated prices
    public void addMeat(String meatType, boolean isExtra) {
        double meatPrice = 0;
        switch(size) {
            case 4:
                meatPrice = isExtra ? 1.50 : 1.00;
                break;
            case 12:
                meatPrice = isExtra ? 2.50 : 2.00;
                break;
            case 18:
                meatPrice = isExtra ? 3.50 : 3.00;
                break;
        }
        price += meatPrice;
        meats.add(new Toppings("meat", meatType, meatPrice));
    }
    // Method to add cheese with updated prices
    public void addCheese(String cheeseType, boolean isExtra) {
        double cheesePrice = 0;
        switch(size) {
            case 4:
                cheesePrice = isExtra ? 1.05 : 0.75;
                break;
            case 12:
                cheesePrice = isExtra ? 2.10 : 1.50;
                break;
            case 18:
                cheesePrice = isExtra ? 3.15 : 2.25;
                break;
        }
        price += cheesePrice;
    }
    // Method to add regular toppings
    public void addRegularTopping(String topping) {
        regularToppings.add(topping);
        // Regular toppings do not affect the price
    }
    public String writeToppings() {
        StringBuilder toppingsConvertedString = new StringBuilder("");
        for (Toppings topping : meats) {
            toppingsConvertedString.append("+" + topping.getType() + "\n");
        }
        for (Toppings topping : cheeses) {
            toppingsConvertedString.append("+" + topping.getType() + "\n");
        }
        for (String topping : regularToppings) {
            toppingsConvertedString.append("+" + topping + "\n");
        }
        for (String topping : sauces) {
            toppingsConvertedString.append("+" + topping + "\n");
        }
        return toppingsConvertedString.toString();
    }
    // Method to add sauces
    public void addSauce(String sauce) {
        sauces.add(sauce);
        // Sauces do not affect the price
    }
    //Getters
    public int getSize() {
        return size;
    }
    public String getBreadType() {
        return breadType;
    }
    public List<Toppings> getMeats() {
        return meats;
    }
    public List<Toppings> getCheeses() {
        return cheeses;
    }
    public List<String> getRegularToppings() {
        return regularToppings;
    }
    public List<String> getSauces() {
        return sauces;
    }
    public boolean isToasted() {
        return toasted;
    }
    public double getPrice() {
        return price;
    }

    // Method to get description of sandwiches
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append("Bread Type: ").append(breadType).append("\n");
        description.append("Size: ").append(size).append(" inches\n");
        description.append("Toasted: ").append(toasted ? "Yes" : "No").append("\n");

        if (!meats.isEmpty()) {
            description.append("Meats: ").append(meats.stream().map(Toppings::getName).collect(Collectors.joining(", "))).append("\n");
        }
        if (!cheeses.isEmpty()) {
            description.append("Cheeses: ").append(cheeses.stream().map(Toppings::getName).collect(Collectors.joining(", "))).append("\n");
        }
        if (!regularToppings.isEmpty()) {
            description.append("Regular Toppings: ").append(String.join(", ", regularToppings)).append("\n");
        }
        if (!sauces.isEmpty()) {
            description.append("Sauces: ").append(String.join(", ", sauces)).append("\n");
        }

        description.append(String.format("Price: $%.2f", price));

        return description.toString();
    }

}