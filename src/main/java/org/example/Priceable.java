package org.example;

public interface Priceable {
    double getPrice();
    String getDescription();

    default String getFormattedPrice() {
        return String.format("$%.2f", getPrice());
    }
}
