package org.example.ui;

import org.example.models.*;
import org.example.util.ReceiptWriter;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order currentOrder;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    //Displays the main menu to get user selections
    public int showHomeScreen() {
        System.out.println("\n====Kari's Creole Deli \uD83E\uDD6A====");
        System.out.println("1. View Menu");
        System.out.println("2. Place an Order");
        System.out.println("0. Exit");
        System.out.print("Please choose an option: ");

        //Validates input 0-2
        return getIntInput(0, 2);
    }

    //Displays the order menu
    public int showOrderMenu() {
        System.out.println("\n=== YOUR ORDER ===");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
        System.out.print("Please choose an option: ");

        //VAlidates input 0-4
        return getIntInput(0, 4);
    }

    public void startNewOrder() {
        currentOrder = new Order();
        System.out.println("\nNew order started. You can now add items.");
    }

    public void addSandwichToOrder() {
        System.out.println("\n=== Build Your Sandwich ===");
        String breadType = promptForBreadType();
        int size = promptForSize();
        boolean toasted = promptForToasted();

        Sandwich sandwich = new Sandwich(breadType, size, toasted);
        addMeatsToSandwich(sandwich);
        addCheesesToSandwich(sandwich);
        addRegularToppings(sandwich);
        addSauces(sandwich);

        currentOrder.addItem(sandwich);
        System.out.println("\nAdded to Order: ");
        System.out.println(sandwich.getDescription());
    }

    private String promptForBreadType() {
        System.out.println("Bread Types: ");
        System.out.println("- White\n- Wheat\n- Rye\n- Wrap");
        System.out.print("Choose bread type: ");
        return scanner.nextLine().trim();
    }

    private int promptForSize() {
        System.out.print("What size? (4in, 8in, 12 inches): ");
        int size;
        while (true) {
            size = getIntInput(4, 12);
            if (size == 4 || size == 8 || size == 12) {
                break;
            }
            System.out.println("Invalid size. Please enter 4, 8, or 12 inches.");
        }
        return size;
    }

    private boolean promptForToasted() {
        System.out.print("Would you like it toasted? (yes/no): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.startsWith("y");
    }

    private void addMeatsToSandwich(Sandwich sandwich) {
        System.out.println("\nAvailable Meats: ");
        System.out.println("- Steak\n- Crispy Chicken\n- Turkey\n- Ham\n- Roast Beef\n- Salami\n- Bacon");
        System.out.println("(Enter 'done' when finished)");

        while (true) {
            System.out.print("Enter meat type: ");
            String meat = scanner.nextLine().trim();
            if (meat.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Extra meat? (yes/no): ");
            boolean extra = scanner.nextLine().trim().equalsIgnoreCase("yes");
            sandwich.addMeat(meat, extra);
        }
    }

    private void addCheesesToSandwich(Sandwich sandwich) {
        System.out.println("\nAvailable Cheeses:");
        System.out.println("- American\n- Provolone\n- Cheddar\n- Swiss");
        System.out.println("(Enter 'done' when finished)");

        while (true) {
            System.out.print("Add cheese (or 'done'): ");
            String cheese = scanner.nextLine().trim();
            if (cheese.equalsIgnoreCase("done")) break;

            System.out.print("Extra cheese? (yes/no): ");
            boolean extra = scanner.nextLine().trim().toLowerCase().startsWith("y");
            sandwich.addCheese(cheese, extra);
        }
    }

    private void addRegularToppings(Sandwich sandwich) {
        System.out.println("\nAvailable Regular Toppings (no extra charge):");
        System.out.println("- Lettuce\n- Peppers\n- Onions\n- Tomatoes\n- Jalapeños\n- Cucumbers\n- Pickles\n- Guacamole\n- Mushrooms");
        System.out.println("(Enter 'done' when finished)");

        while (true) {
            System.out.print("Add topping (or 'done'): ");
            String topping = scanner.nextLine().trim();
            if (topping.equalsIgnoreCase("done")) break;
            sandwich.addRegularTopping(topping);
        }
    }

    private void addSauces(Sandwich sandwich) {
        System.out.println("\nAvailable Sauces (no extra charge):");
        System.out.println("- Mayo\n- Mustard\n- Ketchup\n- Ranch\n- Thousand Island\n- Vinaigrette");
        System.out.println("(Enter 'done' when finished)");

        while (true) {
            System.out.print("Add sauce (or 'done'): ");
            String sauce = scanner.nextLine().trim();
            if (sauce.equalsIgnoreCase("done")) break;
            sandwich.addSauce(sauce);
        }
    }

    public void addDrinkToOrder() {
        System.out.println("\n=== ADD A DRINK ===");
        System.out.print("Size (small, medium, large): ");
        String size = scanner.nextLine().trim();
        System.out.print("Flavor: ");
        String flavor = scanner.nextLine().trim();

        Drink drink = new Drink(size, flavor);
        currentOrder.addItem(drink);
        System.out.println("\nAdded to order:");
        System.out.println(drink.getDescription());
    }

    public void addChipsToOrder() {
        System.out.println("\n=== ADD CHIPS ===");
        System.out.print("Chip type: ");
        String type = scanner.nextLine().trim();

        Chips chips = new Chips(type, 1.75); // Assuming a fixed price for chips
        currentOrder.addItem(chips);
        System.out.println("\nAdded to order:");
        System.out.println(chips.getDescription());
    }
    public void viewCurrentOrder() {
        if (currentOrder == null || currentOrder.getOrder().isEmpty()) {
            System.out.println("\nNo active order. Please start a new order first.");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();  // Wait for user
            return;
        }

        System.out.println("\n=== CURRENT ORDER ===");
        System.out.println(currentOrder.getOrderSummary());
        System.out.println("Press Enter to continue...");
        scanner.nextLine();  // Wait for user
    }
    public void checkout() {
        System.out.println("\n=== CHECKOUT ===");
        System.out.println(currentOrder.getOrderSummary());
        System.out.print("\nConfirm order? (yes/no): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.startsWith("y")) {
            ReceiptWriter.saveReceipt(currentOrder);
            System.out.println("Order confirmed! Thank you!");
        } else {
            System.out.println("Order cancelled.");
        }
        currentOrder = null;
    }

    public void cancelOrder() {
        System.out.println("Order cancelled.");
        currentOrder = null;
    }

    private int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}