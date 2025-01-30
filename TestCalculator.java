//David Edet Henshaw, U23CE1040, Civil Engineering (200L)

package assignment;

import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        DavidCalculator calculator = new DavidCalculator(num1, num2);

        System.out.print("Enter a numerical operator (Add, Subtract, Multiply, Divide): ");
        String numerical_operator = scanner.next();

        if (numerical_operator.equals("Add") || numerical_operator.equals("+")) {
            System.out.println("Result: " + calculator.add());
        } else if (numerical_operator.equals("Subtract") || numerical_operator.equals("-")) {
            System.out.println("Result: " + calculator.subtract());
        } else if (numerical_operator.equals("Multiply") || numerical_operator.equals("*")) {
            System.out.println("Result: " + calculator.multiply());
        } else if (numerical_operator.equals("Divide") || numerical_operator.equals("/")) {
            try {
            System.out.println("Result: " + calculator.divide());
            } catch (ArithmeticException e) {
            System.out.println("syntax error");
            }
        } else {
            System.out.println("Invalid numerical_operator.");
        }

    }
}
