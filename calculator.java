import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.println("-----------------");

        while (true) { // Loop for continuous calculations
            try {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char operator = scanner.next().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero!");
                        }
                        result = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator!");
                }

                System.out.println("Result: " + result);
                System.out.println(); // Add a newline for better readability

                System.out.print("Do you want to perform another calculation? (yes/no): ");
                String continueCalculation = scanner.next().toLowerCase();
                if (!continueCalculation.equals("yes")) {
                    break; // Exit the loop if the user doesn't want to continue
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.next(); // Clear the invalid input from the scanner
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("Thank you for using the calculator!");
        scanner.close(); // Close the scanner to prevent resource leaks
    }
}
