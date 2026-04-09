package Level_1;

import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("🔄  SMART PALINDROME CHECKER  🔄");
        System.out.println("=====================================");
        
        System.out.print("Enter a word or phrase: ");
        String originalText = scanner.nextLine();

        // 🔥 THE PRO MOVE: Remove all spaces & punctuations, and convert to lowercase
        String cleanedText = originalText.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Use StringBuilder to easily reverse the string
        String reversedText = new StringBuilder(cleanedText).reverse().toString();

        System.out.println("\nAnalyzing...");
        System.out.println("Cleaned version: [" + cleanedText + "]");

        // Check condition
        if (cleanedText.equals(reversedText)) {
            System.out.println("✅ RESULT: YES! It is a Palindrome.");
        } else {
            System.out.println("❌ RESULT: NO! It is NOT a Palindrome.");
        }

        scanner.close();
    }
}