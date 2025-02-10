import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square");
            System.out.println("6. Square Root");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println("Exiting...");
                break;
            }

            double num1 = 0, num2 = 0;
            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
            } else if (choice == 5 || choice == 6) {
                System.out.print("Enter the number: ");
                num1 = scanner.nextDouble();
            }

            switch (choice) {
                case 1:
                    System.out.println("Result: " + add(num1, num2));
                    break;
                case 2:
                    System.out.println("Result: " + subtract(num1, num2));
                    break;
                case 3:
                    System.out.println("Result: " + multiply(num1, num2));
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Cannot divide by zero.");
                    } else {
                        System.out.println("Result: " + divide(num1, num2));
                    }
                    break;
                case 5:
                    System.out.println("Result: " + square(num1));
                    break;
                case 6:
                    if (num1 < 0) {
                        System.out.println("Cannot calculate square root of a negative number.");
                    } else {
                        System.out.println("Result: " + squareRoot(num1));
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static double square(double a) {
        return a * a;
    }

    public static double squareRoot(double a) {
        return Math.sqrt(a);
    }
}