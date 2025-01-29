import java.util.Scanner;

public class Javacalc2003{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Get valid 2-digit numbers
            double num1 = getValidNumber(scanner, "Enter the first number (1-99): ");
            double num2 = getValidNumber(scanner, "Enter the second number (1-99): ");

            // Get valid operator
            char operator = getValidOperator(scanner);

            // Calculate and handle errors
            double result = calculate(num1, num2, operator);
            if (result == Double.NaN) {
                System.out.println("Invalid operation.");
            } else if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY) {
                System.out.println("Overflow error. Result is too large.");
            } else {
                System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
            }

            // Continue or exit
            if (!continuePrompt(scanner)) {
                break;
            }
        }

        scanner.close();
    }

    private static double getValidNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double num = scanner.nextDouble();
                if (num >= 1 && num <= 99) {
                    return num;
                } else {
                    System.out.println("Please enter a number between 1 and 99.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }

    private static char getValidOperator(Scanner scanner) { 
        while (true) {
            System.out.print("Enter the operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);
            if ("+-*/".indexOf(operator) != -1) {
                return operator;
            } else {
                System.out.println("Invalid operator. Please choose +, -, *, or /.");
            }
        }
    }

    private static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    return Double.NaN; // Not a number
                } else {
                    return num1 / num2;
                }
            default:
                return Double.NaN; // Not a number
        }
    }

    private static boolean continuePrompt(Scanner scanner) {
        System.out.print("Do you want to perform another calculation? (y/n): ");
        char choice = Character.toLowerCase(scanner.next().charAt(0));
        return choice == 'y';
    }
}
