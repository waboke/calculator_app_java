import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("Enter an operator\n" +
        "(Addition,\n" +
        "subtraction,\n" +
        "multiplication,\n" +
        "Division): ");

        char operator = scanner.next().charAt(0);

        double result;

        switch (operator) {
            case 'addition':
                result = num1 + num2;
                break;
            case 'subtraction':
                result = num1 - num2;
                break;
            case 'multiplication':
                result = num1 * num2;
                break;
            case 'division5
            ':
                if (num2 != 0) {
                    result = num1 / num2; // Corrected division order
                } else {
                    System.out.println("Error! Division by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator!");
                return;
        }

        System.out.println("The result is: " + result);
    }
}jj
