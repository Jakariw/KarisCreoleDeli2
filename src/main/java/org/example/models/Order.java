package org.example.models;
import org.example.models.*;
import org.example.Priceable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order<T extends Priceable> {
    private final List<T> items;
    private double totalPrice;

    public Order() {
        items = new ArrayList<>();
        totalPrice = 0.0;
    }

    //Adds a sandwich to the order and updates the total price
    public void addItem(T item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    //getters for order items
    public List<T> getOrder() {
        return new ArrayList<>(items);
    }

    //Calculates the total price of the order
    public double getTotalPrice() {
        return totalPrice;
    }

    //Generates a summary for the order
    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("=== Order Summary ===\n");

        // Filter items by type using instanceof
        List<Sandwich> sandwiches = items.stream()
                .filter(item -> item instanceof Sandwich)
                .map(item -> (Sandwich) item)
                .collect(Collectors.toList());

        List<Drink> drinks = items.stream()
                .filter(item -> item instanceof Drink)
                .map(item -> (Drink) item)
                .collect(Collectors.toList());

        List<Chips> chips = items.stream()
                .filter(item -> item instanceof Chips)
                .map(item -> (Chips) item)
                .collect(Collectors.toList());

        // Build summary sections
        summary.append("Sandwiches\n");
        for (Sandwich sandwich: sandwiches){
            summary.append(sandwich.writeToppings());
            summary.append(sandwich.getSize() +" - " + sandwich.getBreadType());
        }
        summary.append("\nDrinks\n");
        for (Drink drink: drinks) {
            summary.append(drink.getSize() + " - " + drink.getFlavor());
        }
        summary.append("\nChips\n");
        for (Chips chip: chips) {
            summary.append(chip.getDescription());
        }

        summary.append(String.format("\nTotal Price: $%.2f\n", totalPrice));
        return summary.toString();

    }
    // Helper method to build each section
    private <U extends Priceable> void appendSection(StringBuilder builder, String title, List<U> items) {
        builder.append(title).append(":\n");
        if (items.isEmpty()) {
            builder.append("No ").append(title.toLowerCase()).append(" ordered.\n");
        } else {
            items.forEach(item -> builder.append(item.toString()).append("\n"));
        }
    }
}
