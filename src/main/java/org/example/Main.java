package org.example;
import org.example.ui.UserInterface;
public class Main {
    public static void main(String[] args) {
        System.out.println("==Welcome to Kari's Creole Deli==");
        UserInterface ui = new UserInterface();

        // Main application loop
        while (true) {
            // Display home screen and get user selection
            int choice = ui.showHomeScreen();

            switch (choice) {
                case 1: // View Menu
                    displayMenu();
                    break;
                case 2: // Place an Order
                    handleOrder(ui);
                    break;
                case 0: // Exit
                    System.out.println("\nThank you for visiting Kari's Creole Deli!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid selection, please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== OUR MENU ====");
        System.out.println("SANDWICHES\uD83E\uDD6A:");
        System.out.println("- 4\" Sandwich: $5.50");
        System.out.println("- 12\" Sandwich: $7.00");
        System.out.println("- 18\" Sandwich: $8.50");
        System.out.println("\nDRINKS \uD83E\uDD64 :");
        System.out.println("- Small: $1.00");
        System.out.println("- Medium: $2.00");
        System.out.println("- Large: $3.50");
        System.out.println("\nCHIPS\uD83C\uDF5F: $1.75");
        System.out.println("\nEnter 0 to continue...");
        System.out.println("====");
        new java.util.Scanner(System.in).nextLine();
    }

    private static void handleOrder(UserInterface ui) {
        ui.startNewOrder();

        // Order management loop
        while (true) {
            int orderChoice = ui.showOrderMenu();

            switch (orderChoice) {
                case 1: // Add Sandwich
                    ui.addSandwichToOrder();
                    break;

                case 2: // Add Drink
                    ui.addDrinkToOrder();
                    break;

                case 3: // Add Chips
                    ui.addChipsToOrder();
                    break;

                case 4: // Checkout
                    ui.checkout();
                    return;

                case 0: // Cancel Order
                    ui.cancelOrder();
                    return;

                default:
                    System.out.println("Invalid selection, please try again.");
            }
        }
    }
}
