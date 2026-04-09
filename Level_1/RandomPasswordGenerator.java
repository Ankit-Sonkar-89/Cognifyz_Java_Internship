package Level_1;

import java.util.Scanner;
import java.security.SecureRandom; // 🛡️ Used by pros for unhackable randoms

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom(); // Cryptographically secure random number generator

        System.out.println("=====================================");
        System.out.println("🛡️ SECURE PASSWORD GENERATOR 🛡️");
        System.out.println("=====================================");

        System.out.print("Enter the desired password length (e.g., 8, 12, 16): ");
        int length = scanner.nextInt();

        if (length <= 0) {
            System.out.println("⚠️ Password length must be greater than 0!");
            return;
        }

        // Consume the leftover newline character
        scanner.nextLine();

        System.out.print("Include lowercase letters? (y/n): ");
        boolean useLower = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean useUpper = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean useNumbers = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean useSpecial = scanner.nextLine().trim().equalsIgnoreCase("y");

        // Character Pools
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+<>?";

        // Build the valid character pool based on user choices
        StringBuilder characterPool = new StringBuilder();

        if (useLower) characterPool.append(lowerCaseChars);
        if (useUpper) characterPool.append(upperCaseChars);
        if (useNumbers) characterPool.append(numberChars);
        if (useSpecial) characterPool.append(specialChars);

        // Edge case: If user said 'n' to everything
        if (characterPool.length() == 0) {
            System.out.println("❌ Error: You must select at least one character type!");
            return;
        }

        // Generate the Password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // Pick a random index from the pool
            int randomIndex = random.nextInt(characterPool.length());
            // Append the character at that index to our password
            password.append(characterPool.charAt(randomIndex));
        }

        System.out.println("\n=====================================");
        System.out.println("✅ Generated Password: " + password.toString());
        System.out.println("=====================================");

        scanner.close();
    }
}