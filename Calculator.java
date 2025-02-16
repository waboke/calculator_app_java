import java.util.Scanner;

// Class to perform basic arithmetic operations (Add, Subtract, Multiply, Divide)
class Calculator {

    // Method for addition
    public double add(double a, double b) {
        return a + b;
    }

    // Method for subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Method for multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method for division with error handling for division by zero
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;  // Return Not-a-Number if division by zero occurs
        }
        return a / b;
    }
}

// Main class to interact with the user and perform arithmetic operations
public class Main {

    public static void main(String[] args) {

        // Creating an instance of ArithmeticOperations class to perform operations
        CalculatorApp1 operations = new CalculatorApp1();
        Scanner scanner = new Scanner(System.in);

        // Display options for the user
        System.out.println("Welcome to the Simple Calculator!");
        System.out.println("Choose an operation: ");
        System.out.println("+ : Add");
        System.out.println("- : Subtract");
        System.out.println("* : Multiply");
        System.out.println("/ : Divide");

        // Getting operation choice from the user
        System.out.print("Enter operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        // Getting two numbers from the user
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = 0; // Variable to store the result of the operation

        // Perform the operation based on user's choice
        switch (operation) {
            case '+':
                result = operations.add(num1, num2);
                break;
            case '-':
                result = operations.subtract(num1, num2);
                break;
            case '*':
                result = operations.multiply(num1, num2);
                break;
            case '/':
                result = operations.divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operation! Please choose from +, -, *, /.");
                return;  // Exit the program if the operation is invalid
        }

        // Display the result
        System.out.println("Result: " + result);

        scanner.close(); // Closing the scanner resource
    }
}
