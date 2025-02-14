import java.util.Scanner;

public class Nasir_Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------------");
        System.out.println("Welcome to Nasir's Calculator");
        System.out.println("------------------------------");
        System.out.println("   ");
        System.out.println("   ");

        System.out.println("Enter Numbers for calculation...");

        double num1 = getNumberFromUser(scanner, "Enter the first number: ");
        double num2 = getNumberFromUser(scanner, "Enter the second number: ");
        


        System.out.println("\nResults of the calculations:");
        System.out.println("------------------------------");

        performAddition(num1, num2);
        performSubtraction(num1, num2);
        performMultiplication(num1, num2);
        performDivision(num1, num2);

        System.out.println("------------------------------");



        System.out.print("Enter W to perfom specific operation or E to exit program: ");
        char choice = scanner.next().charAt(0);
        if (choice == 'W') {

            // Ask the user to choose an operation
            System.out.print("Choose operation (+, -, *, /): ");
            char operation = scanner.next().charAt(0); // Read the operation character

            double result = 0; // This will store the result of the calculation

            // Perform the operation based on user input
            if (operation == '+') {
                result = num1 + num2; // Add the numbers
            } else if (operation == '-') {
                result = num1 - num2; // Subtract the numbers
            } else if (operation == '*') {
                result = num1 * num2; // Multiply the numbers
            } else if (operation == '/') {
                // We need to check if the second number is not zero to avoid division by zero
                if (num2 != 0) {
                    result = num1 / num2; // Divide the numbers
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                    return; // Exit the program
                }
            } else {
                System.out.println("Invalid operation! Please use +, -, *, or /.");
                return; // Exit the program
            }

            // Print the result of the calculation
            System.out.println("The result of " + num1 + " " + operation + " " + num2 + " is: " + result);
            System.out.println("------------------------------");
        }else if (choice == 'E'){
            System.out.println("Exiting the program.");
            System.out.println("Thank you for using the Nasir's calculator!");

            return;
        }else{
            System.out.println("Invalid choice.");
            System.out.println("Exiting the program.");
            System.out.println("Thank you for using the Nasir's calculator!");
            return;
        }

        
        scanner.close();

        System.out.println("Thank you for using the Nasir's calculator!");

    }

    private static double getNumberFromUser(Scanner scanner, String prompt) {
        double number;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return number;
    }

    private static void performAddition(double num1, double num2) {
        double sum = num1 + num2;
        System.out.printf("Addition: %.2f%n", sum);
    }

    private static void performSubtraction(double num1, double num2) {
        double difference = num1 - num2;
        System.out.printf("Subtraction: %.2f%n", difference);
    }

    private static void performMultiplication(double num1, double num2) {
        double product = num1 * num2;
        System.out.printf("Multiplication: %.2f%n", product);
    }

    private static void performDivision(double num1, double num2) {
        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.printf("Division: %.2f%n", quotient);
        } else {
            System.out.println("Division by zero is not possible.");
        }
    }
}
