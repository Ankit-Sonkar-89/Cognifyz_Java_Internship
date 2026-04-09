package Level_1;

import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperature = 0;
        boolean validInput = false;

        System.out.println("=====================================");
        System.out.println("🌡️  PRO TEMPERATURE CONVERTER 🌡️");
        System.out.println("=====================================");

        // 1. Take Valid Temperature Input
        while (!validInput) {
            System.out.print("Enter the temperature value: ");
            try {
                temperature = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input! Please enter a valid number.");
            }
        }

        // 2. Take Valid Unit Input
        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        String unit = scanner.nextLine().trim().toUpperCase();

        // 3. Conversion Logic
        if (unit.equals("C")) {
            double fahrenheit = (temperature * 9 / 5) + 32;
            System.out.printf("✅ Result: %.2f°C is equal to %.2f°F%n", temperature, fahrenheit);
        } else if (unit.equals("F")) {
            double celsius = (temperature - 32) * 5 / 9;
            System.out.printf("✅ Result: %.2f°F is equal to %.2f°C%n", temperature, celsius);
        } else {
            System.out.println("❌ Invalid unit entered! Please restart and enter 'C' or 'F'.");
        }

        scanner.close();
    }
}


