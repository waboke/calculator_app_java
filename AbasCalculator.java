import java.util.Scanner;

public class AbasCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Abas's Calculator");
        System.out.println("-------------------");

        double num1 = getNumberFromUser(scanner, "Enter the first number: ");
        double num2 = getNumberFromUser(scanner, "Enter the second number: ");

        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        int choice = getOperationChoice(scanner);

        System.out.println("\nResult:");
        switch (choice) {
            case 1:
                performOperation("Addition", num1, num2, (a, b) -> a + b);
                break;
            case 2:
                performOperation("Subtraction", num1, num2, (a, b) -> a - b);
                break;
            case 3:
                performOperation("Multiplication", num1, num2, (a, b) -> a * b);
                break;
            case 4:
                performOperation("Division", num1, num2, (a, b) -> b != 0 ? a / b : Double.NaN);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid operation.");
        }

        scanner.close();
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
                scanner.next(); 
            }
        }
        return number;
    }

    private static int getOperationChoice(Scanner scanner) {
        int choice;
        while (true) {
            System.out.print("Enter your choice (1-4): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    break;  
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); 
            }
        }
        return choice;
    }

    private static void performOperation(String operation, double num1, double num2, CalculatorOperation op) {
        double result = op.execute(num1, num2);
        if (Double.isNaN(result)) {
            System.out.println(operation + ": Division by zero is not possible.");
        } else {
            System.out.printf("%s: %.2f%n", operation, result);
        }
    }

    @FunctionalInterface
    private interface CalculatorOperation {
        double execute(double num1, double num2);
    }
}
