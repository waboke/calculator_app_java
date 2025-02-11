import java.util.Scanner;

public class AdvancedCalculator {
    private static double memory = 0; // Stores memory value
    private static double lastResult = 0; // Stores last result

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number from the menu.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 10) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            double num1, num2, result = 0;
            boolean validOperation = true;

            switch (choice) {
                case 1: case 2: case 3: case 4: case 7: // Operations needing two numbers
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    result = performOperation(choice, num1, num2);
                    break;

                case 5: // Square root
                    System.out.print("Enter number: ");
                    num1 = scanner.nextDouble();
                    if (num1 < 0) {
                        System.out.println("Error: Cannot calculate square root of a negative number.");
                        validOperation = false;
                    } else {
                        result = Math.sqrt(num1);
                    }
                    break;

                case 6: // Power
                    System.out.print("Enter base: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    num2 = scanner.nextDouble();
                    result = Math.pow(num1, num2);
                    break;

                case 8: // Store memory
                    memory = lastResult;
                    System.out.println("Stored " + memory + " in memory.");
                    validOperation = false;
                    break;

                case 9: // Recall memory
                    System.out.println("Memory Value: " + memory);
                    validOperation = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    validOperation = false;
            }

            if (validOperation) {
                lastResult = result;
                System.out.println("Result: " + result);
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== Advanced Calculator =====");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square Root");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Modulus");
        System.out.println("8. Store Memory");
        System.out.println("9. Recall Memory");
        System.out.println("10. Exit");
    }

    private static double performOperation(int choice, double num1, double num2) {
        switch (choice) {
            case 1: return num1 + num2;
            case 2: return num1 - num2;
            case 3: return num1 * num2;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Division by zero.");
                    return 0;
                }
                return num1 / num2;
            case 7: return num1 % num2;
            default: return 0;
        }
    }
                      }
