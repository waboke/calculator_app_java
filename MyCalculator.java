import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Select an operation:");
            System.out.println("1 : Addition (+)");
            System.out.println("2 : Subtraction (-)");
            System.out.println("3 : Multiplication (*)");
            System.out.println("4 : Division (/)");
            System.out.println("5 : Modulus (%)");
            System.out.println("6 : Square (^)");
            System.out.println("7 : Square Root (√)");
            System.out.print("Enter the number corresponding to the operation: ");
            int choice = scanner.nextInt();

            double num1 = 0, num2 = 0, result = 0;

            if (choice == 7) { // Square Root
                System.out.print("Enter a number: ");
                num1 = scanner.nextDouble();
                if (num1 >= 0) {
                    result = Math.sqrt(num1);
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error! Square root of negative numbers is not allowed.");
                }
            } else if (choice == 6) { // Square
                System.out.print("Enter a number: ");
                num1 = scanner.nextDouble();
                result = num1 * num1;
                System.out.println("Result: " + result);
            } else {
                // For other operations, two numbers are required
                System.out.print("Enter first number: ");
                num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();

                switch (choice) {
                    case 1: // Addition
                        result = num1 + num2;
                        System.out.println("Result: " + result);
                        break;
                    case 2: // Subtraction
                        result = num1 - num2;
                        System.out.println("Result: " + result);
                        break;
                    case 3: // Multiplication
                        result = num1 * num2;
                        System.out.println("Result: " + result);
                        break;
                    case 4: // Division
                        if (num2 != 0) {
                            result = num1 / num2;
                            System.out.println("Result: " + result);
                        } else {
                            System.out.println("Error! Division by zero is not allowed.");
                        }
                        break;
                    case 5: // Modulus
                        result = num1 % num2;
                        System.out.println("Result: " + result);
                        break;
                    default:
                        System.out.println("Invalid choice! Please select a valid operation.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid numbers and choices.");
        } finally {
            scanner.close();
        }
    }
}
