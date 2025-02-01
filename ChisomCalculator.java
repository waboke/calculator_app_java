import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            try {
                System.out.println("Simple Calculator by U23MME1020");
                System.out.println("Select any operation to perform:");
                System.out.println("1. Addition operation");
                System.out.println("2. Subtraction operation");
                System.out.println("3. Multiplication operation");
                System.out.println("4. Division operation");
                System.out.println("5. Exit calculator");
                System.out.print("Enter any choice (1-5): ");
                int choice = scanner.nextInt();

                if (choice == 5) {
                    System.out.println("Exiting the calculator. Goodbye!");
                    continueLoop = false;
                } else if (choice < 1 || choice > 5) {
                    System.out.println("Invalid operation choice. Please choose a number between 1 and 5.");
                } else {
                    System.out.print("Enter the first number: ");
                    double num1 = scanner.nextDouble();

                    System.out.print("Enter the second number: ");
                    double num2 = scanner.nextDouble();

                    double result = 0;

                    switch (choice) {
                        case 1:
                            result = num1 + num2;
                            System.out.println(num1 + " + " + num2 + " = " + result);
                            break;
                        case 2:
                            result = num1 - num2;
                            System.out.println(num1 + " - " + num2 + " = " + result);
                            break;
                        case 3:
                            result = num1 * num2;
                            System.out.println(num1 + " * " + num2 + " = " + result);
                            break;
                        case 4:
                            if (num2 != 0) {
                                result = num1 / num2;
                                System.out.println(num1 + " / " + num2 + " = " + result);
                            } else {
                                System.out.println("Error! Division by zero is not allowed.");
                            }
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.close();
    }
}
