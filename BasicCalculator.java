import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation) {
            try {
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                System.out.print("Enter the operator (+, -, *, /, %, ^): ");
                char operator = scanner.next().charAt(0);

                double result = performCalculation(num1, num2, operator);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values.");
                scanner.next(); // Clear invalid input
                continue;
            }

            // Ask if user wants to perform another calculation
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String response = scanner.next();
            continueCalculation = response.equalsIgnoreCase("yes");
        }
        System.out.println("Calculator exiting. Goodbye!");
        scanner.close();
    }

    // Separate method for arithmetic operations
    public static double performCalculation(double num1, double num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': 
                if (num2 != 0) return num1 / num2;
                System.out.println("Error: Division by zero is undefined.");
                return Double.NaN;
            case '%': 
                if (num2 != 0) return num1 % num2;
                System.out.println("Error: Modulus by zero is undefined.");
                return Double.NaN;
            case '^': return Math.pow(num1, num2);
            default:
                System.out.println("Error: Invalid operator.");
                return Double.NaN;
        }
    }
}
