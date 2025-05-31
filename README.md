# Kari's Creole Deli ⚜️ 🥪

Kari's Creole Deli is a Java-based sandwich shop application that uses Object-Oriented Programming to allow customers to build custom sandwiches to their preference, also add drinks, chips, and place orders with a receipt generation that are saved to a txt file placed in receipts folder.


## 📚 Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Application Structure](#application-structure)
- [Usage Examples](#usage-examples)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)

## ✨ Features

### 🥖 Sandwich Builder
- Customize sandwiches with:
  - 3 size options (4", 12", 18")
  - 4 bread types (White, Wheat, Rye, Wrap)
  - 7 meat options with extra meat option
  - 4 cheese options with extra cheese option
  - 9 regular toppings
  - 6 sauces
  - Toasting option

### 🍲 Additional Items
- Add drinks in 3 sizes (small, medium, large) with custom flavors
- Add various chip types at fixed price

### 📑 Order Management
- View current order summary
- Add/remove items
- Checkout with receipt generation
- Cancel order option

### 📝 Receipt Generation
- Automatic timestamped receipts saved to `/receipts` directory
- Detailed order breakdown with pricing

## 💻 Technologies Used

- **Core Java**: Object-oriented design with interfaces and polymorphism
- **File I/O**: For receipt generation and storage
- **Collections Framework**: For managing order items
- **DateTime API**: For receipt timestamping
- **Gradle/Maven**: For dependency management (specify which you're using)

## 📌 Getting Started

### Prerequisites
- Java JDK 11 or higher
- (Optional) Gradle/Maven if building with dependencies

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/karis-creole-deli.git
   ```
2. Navigate to project directory:
   ```bash
   cd karis-creole-deli
   ```
3. Compile and run:
   ```bash
   javac -d out src/main/java/org/example/*.java src/main/java/org/example/models/*.java src/main/java/org/example/ui/*.java src/main/java/org/example/util/*.java
   java -cp out org.example.Main
   ```

## 🗂️ Application Structure

```
src/
├── main/
│   ├── java/
│   │   ├── org.example/
│   │   │   ├── models/          # Domain models
│   │   │   │   ├── Sandwich.java
│   │   │   │   ├── Drink.java
│   │   │   │   ├── Chips.java
│   │   │   │   ├── Order.java
│   │   │   │   └── Toppings.java
│   │   │   ├── ui/             # User interface
│   │   │   │   └── UserInterface.java
│   │   │   ├── util/           # Utilities
│   │   │   │   └── ReceiptWriter.java
│   │   │   ├── Priceable.java  # Interface
│   │   │   └── Main.java       # Entry point
│   └── resources/
```

## 📋 Usage Examples

### Building a Sandwich
1. Select "Place an Order" from main menu
2. Choose "Add Sandwich"
3. Select bread type, size, and toasting preference
4. Add meats, cheeses, toppings, and sauces
5. Review sandwich description and price

### Complete Order Flow
```text
=== Kari's Creole Deli ===
1. View Menu
2. Place an Order
0. Exit
> 2

=== YOUR ORDER ===
1) Add Sandwich
2) Add Drink
3) Add Chips
4) Checkout
0) Cancel Order
> 1

=== Build Your Sandwich ===
Bread Types: White, Wheat, Rye, Wrap
Choose bread type: Wrap
What size? (4in, 8in, 12in): 12
Toasted? (yes/no): yes

Available Meats: Steak, Crispy Chicken, Turkey, Ham...
Enter meat type: Steak
Extra meat? (yes/no): yes
...
[Order summary displays at checkout]
```

## 📩 Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your improvements.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

Distributed under the MIT License. See `LICENSE` for more information.


## 📈 UML Diagram:
<img width="667" alt="Screen Shot 2025-05-30 at 4 39 28 PM" src="https://github.com/user-attachments/assets/a5db6d8f-7336-45ad-abea-c6a83075eb8f" />


# Enjoy!
