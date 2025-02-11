import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        // Create a Scanner object to get input from the user
        Scanner scanner = new Scanner(System.in);

        // Display the calculator menu
        System.out.println("Welcome to the Calculator!");
        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Display options for operations
        System.out.println("Choose an operation (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result = 0;

        // Perform calculation based on the operator
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
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error! Division by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator! Please use +, -, *, or /.");
                return;
        }

        // Display the result
        System.out.println("The result is: " + result);

        // Close the scanner
        scanner.close();
    }
}
