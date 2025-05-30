package org.example.models;

public class Toppings {
    private String type;
    private String name;
    private double price;

    public Toppings(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return name + (price > 0 ? String.format("%.2f", price) : "");
    }
}
