import java.util.Scanner;

public class ConsoleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double lastNumber = null; // Stores the last valid number

        System.out.println("Console Calculator");
        System.out.println("Operations: +, -, *, /, ^ (exponent), x² (square)");
        System.out.println("Type 'C' to clear, 'del' to delete last entry, 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter first number (or 'del' to delete last entry): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            if (input.equalsIgnoreCase("del")) {
                if (lastNumber != null) {
                    System.out.println("Deleted last entry: " + lastNumber);
                    lastNumber = null;
                } else {
                    System.out.println("No previous entry to delete.");
                }
                continue; // Restart loop
            }

            double num1;
            try {
                num1 = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter number.");
                continue;
            }

            lastNumber = num1; // Store the valid number

            System.out.print("Enter operator (+, -, *, /, ^, x²): ");
            String operator = scanner.next();

            double result;
            if (operator.equals("x²")) {
                result = num1 * num1;
            } else {
                System.out.print("Enter second number: ");
                String secondInput = scanner.next();

                if (secondInput.equalsIgnoreCase("del")) {
                    System.out.println("Deleted last entry: " + num1);
                    lastNumber = null;
                    continue;
                }

                double num2;
                try {
                    num2 = Double.parseDouble(secondInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    continue;
                }

                lastNumber = num2; // Store second number for possible deletion

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Error: Division by zero! Try again.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    case "^":
                        result = Math.pow(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid operator! Try again.");
                        continue;
                }
            }

            System.out.println("Result: " + result);
        }

        scanner.close(); // Close the scanner when done
    }
}
