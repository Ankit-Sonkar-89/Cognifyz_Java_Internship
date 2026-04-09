package Level_2;

import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("🛡️ ADVANCED PASSWORD STRENGTH CHECKER");
        System.out.println("=====================================");

        System.out.print("Enter your password to analyze: ");
        String password = scanner.nextLine();

        int score = 0;
        StringBuilder feedback = new StringBuilder("\n🔍 Feedback:\n");

        // 1. Length Check
        if (password.length() >= 8) {
            score++;
            feedback.append("✅ Good length (8+ characters).\n");
        } else {
            feedback.append("❌ Too short! Make it at least 8 characters.\n");
        }

        // 2. Uppercase Check
        if (password.matches(".*[A-Z].*")) {
            score++;
            feedback.append("✅ Contains uppercase letters.\n");
        } else {
            feedback.append("❌ Missing uppercase letters (A-Z).\n");
        }

        // 3. Lowercase Check
        if (password.matches(".*[a-z].*")) {
            score++;
            feedback.append("✅ Contains lowercase letters.\n");
        } else {
            feedback.append("❌ Missing lowercase letters (a-z).\n");
        }

        // 4. Number Check
        if (password.matches(".*\\d.*")) {
            score++;
            feedback.append("✅ Contains numbers.\n");
        } else {
            feedback.append("❌ Missing numbers (0-9).\n");
        }

        // 5. Special Character Check
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            score++;
            feedback.append("✅ Contains special characters.\n");
        } else {
            feedback.append("❌ Missing special characters (e.g., !@#$%^&*).\n");
        }

        System.out.println(feedback.toString());
        System.out.print("📈 Final Strength: ");

        switch (score) {
            case 5:
                System.out.println("🔥🔥 VERY STRONG (Hacker-Proof!)");
                break;
            case 4:
                System.out.println("🔥 STRONG (Good to go)");
                break;
            case 3:
                System.out.println("⚠️ MODERATE (Could be better)");
                break;
            default:
                System.out.println("🛑 WEAK (Easily Hackable!)");
        }
        
        System.out.println("=====================================");
        scanner.close();
    }
}