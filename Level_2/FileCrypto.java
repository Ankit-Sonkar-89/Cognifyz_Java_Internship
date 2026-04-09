package Level_2;

import java.io.*;
import java.util.Scanner;

public class FileCrypto {

    // Simple Caesar Cipher key (Shifts ASCII value by 5)
    private static final int KEY = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("🔐 PRO FILE ENCRYPTOR / DECRYPTOR 🔐");
        System.out.println("=====================================");

        System.out.print("Choose operation (1 for Encrypt, 2 for Decrypt): ");
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter 1 or 2.");
            return;
        }

        if (choice != 1 && choice != 2) {
            System.out.println("❌ Invalid choice. Please enter 1 or 2.");
            return;
        }

        System.out.print("Enter the path of the input file (e.g., secret.txt): ");
        String inputFile = scanner.nextLine().trim();

        System.out.print("Enter the path of the output file (e.g., locked.txt): ");
        String outputFile = scanner.nextLine().trim();

        processFile(inputFile, outputFile, choice == 1);

        scanner.close();
    }

    private static void processFile(String inputPath, String outputPath, boolean isEncrypt) {
        // 🔥 THE PRO MOVE: Try-With-Resources (Auto-closes files, prevents memory leaks)
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            int ch;
            // Read file character by character
            while ((ch = reader.read()) != -1) {
                char character = (char) ch;
                
                // Shift the character's ASCII value
                if (isEncrypt) {
                    character += KEY;
                } else {
                    character -= KEY;
                }
                
                writer.write(character);
            }

            System.out.println("\n✅ SUCCESS! File has been " + (isEncrypt ? "encrypted 🔒" : "decrypted 🔓") + " successfully.");
            System.out.println("📂 Saved to: " + outputPath);

        } catch (FileNotFoundException e) {
            System.out.println("❌ Error: The file '" + inputPath + "' was not found. Make sure it exists!");
        } catch (IOException e) {
            System.out.println("❌ Error processing the file: " + e.getMessage());
        }
    }
}