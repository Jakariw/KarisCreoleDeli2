package org.example.models;
import org.example.Priceable;

public class Drink implements Priceable {
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;

        //set price based on size
        switch (size.toLowerCase()) {
            case "small":
                this.price = 1.00;
                break;
            case "medium":
                this.price = 2.00;
                break;
            case "large":
                this.price = 3.50;
                break;
            default:
                this.price = 0;
        }
    }
    public String getSize() {
        return size;
    }
    public String getFlavor() {
        return flavor;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return String.format("%s %s Drink - $%.2f", size, flavor, price);
    }
}
