package org.example.models;
import org.example.Priceable;
public class Chips implements Priceable {
    private String type;
    private double price;

    public Chips(String type, double price) {
        this.type = type;
        this.price = 1.75;
    }

    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return String.format("%s Chips - $%.2f", type, price);
    }
}