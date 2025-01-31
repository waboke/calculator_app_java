import java.util.Scanner;

public class Easycalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result;

        System.out.println("Easy Calc");
        System.out.println("Supported operators: +, -, *, /, %, ^");
        System.out.println("Enter calculations in the format: number operator number (e.g., 5 + 3)");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter calculation: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Easy calc. Goodbye!");
                break;
            }

            String[] parts = input.split(" ");

            // Check if input format is correct
            if (parts.length != 3) {
                System.out.println("Error: Invalid format. Please enter in the format 'number operator number'.");
                continue;
            }

            try {
                double num1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double num2 = Double.parseDouble(parts[2]);

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
                            System.out.println("Error: Cannot divide by zero.");
                            continue;
                        }
                        result = num1 / num2;
                        break;
                    case "%":
                        result = num1 % num2;
                        break;
                    case "^":
                        result = Math.pow(num1, num2);
                        break;
                    default:
                        System.out.println("Error: Invalid operator. Supported operators are: +, -, *, /, %, ^.");
                        continue;
                }
                System.out.println("Ans: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please enter valid numbers.");
            } catch (Exception e) {
                System.out.println("Error: Something went wrong. Please try again.");
            }
        }

        scanner.close();
    }
        }
