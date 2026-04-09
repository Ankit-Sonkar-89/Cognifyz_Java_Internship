package Level_1;

import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("📊 PRO STUDENT GRADE CALCULATOR 📊");
        System.out.println("=====================================");

        System.out.print("Enter the number of grades you want to enter: ");
        int numOfGrades = scanner.nextInt();

        // Edge case handling
        if (numOfGrades <= 0) {
            System.out.println("⚠️ Please enter a valid number of grades (greater than 0).");
            return;
        }

        // Array to store all grades
        double[] grades = new double[numOfGrades];
        double sum = 0;

        for (int i = 0; i < numOfGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + " (0-100): ");
            double grade = scanner.nextDouble();

            // Validation: Grade should be between 0 and 100
            if (grade < 0 || grade > 100) {
                System.out.println("❌ Invalid grade! Please enter a value between 0 and 100.");
                i--; // Decrement i so the loop asks for the same subject's grade again
                continue;
            }

            grades[i] = grade;
            sum += grade;
        }

        // Calculate Average
        double average = sum / numOfGrades;

        System.out.println("\n=====================================");
        System.out.printf("✅ Total Score: %.2f%n", sum);
        System.out.printf("📈 Average Grade: %.2f%%%n", average);
        
        // Bonus: Grade Letter Logic
        char letterGrade = (average >= 90) ? 'A' : (average >= 80) ? 'B' : (average >= 70) ? 'C' : (average >= 60) ? 'D' : 'F';
        System.out.println("🏆 Final Letter Grade: " + letterGrade);
        System.out.println("=====================================");

        scanner.close();
    }
}