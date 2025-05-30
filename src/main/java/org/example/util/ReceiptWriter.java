package org.example.util;

import org.example.models.Order;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    //Generates a timestamp string for the receipt filename
    private static String generateTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return LocalDateTime.now().format(formatter);
    }
    public static void saveReceipt(Order order) {
        Path receiptsDir = Paths.get("receipts");
        try {
            Files.createDirectories(receiptsDir);
        } catch (IOException e) {
            System.err.println("Error creating receipts directory: " + e.getMessage());
            return;
        }

        String timestamp = generateTimestamp();
        String filename = receiptsDir.resolve("order_" + timestamp.replace(":", "-") + ".txt").toString();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        // Write order details to file
        writer.write(order.getOrderSummary());
        writer.newLine();
        writer.write("Thank you for your order!");

        System.out.println("Receipt saved as: " + filename);
    } catch (IOException e) {
        System.err.println("Error saving receipt: " + e.getMessage());
    }
}
}