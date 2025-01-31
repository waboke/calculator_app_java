import java.util.Scanner;

public class ChisomCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Eriobu's Calculator");
        System.out.println("-------------------");

        double num1 = getNumberFromUser(scanner, "Enter the first number: ");
        double num2 = getNumberFromUser(scanner, "Enter the second number: ");

        System.out.println("\nResults:");
        System.out.println("--------");

        performAddition(num1, num2);
        performSubtraction(num1, num2);
        performMultiplication(num1, num2);
        performDivision(num1, num2);

        scanner.close();
    }

    private static double getNumberFromUser(Scanner scanner, String prompt) {
        double number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return number;
    }

    private static void performAddition(double num1, double num2) {
        double sum = num1 + num2;
        System.out.printf("Addition: %.2f%n", sum);
    }

    private static void performSubtraction(double num1, double num2) {
        double difference = num1 - num2;
        System.out.printf("Subtraction: %.2f%n", difference);
    }

    private static void performMultiplication(double num1, double num2) {
        double product = num1 * num2;
        System.out.printf("Multiplication: %.2f%n", product);
    }

    private static void performDivision(double num1, double num2) {
        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.printf("Division: %.2f%n", quotient);
        } else {
            System.out.println("Division by zero is not possible.");
        }
    }
}