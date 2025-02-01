import java.util.Scanner;

class ConsoleCalculator {
    public static void main(String[] args) {
        // Create Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Variables to store operands and result
        double num1, num2, result;
        String operator;

        // User interaction loop
        while (true) {
            // Prompt user for the first number
            System.out.print("Enter first number: ");
            num1 = scanner.nextDouble();

            // Prompt user for the operator
            System.out.print("Enter operator (+, -, *, /): ");
            operator = scanner.next();

            // Prompt user for the second number
            System.out.print("Enter second number: ");
            num2 = scanner.nextDouble();

            // Perform the operation based on the operator input
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
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error! Division by zero is not allowed.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operator! Please try again.");
                    continue;
            }

            // Output the result
            System.out.println("Result: " + result);

            // Ask if the user wants to perform another calculation
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Close scanner
        scanner.close();
        System.out.println("Thank you for using the calculator!");
    }
}
