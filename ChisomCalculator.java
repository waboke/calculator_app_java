import java.util.Scanner;

public class AwesomeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;

        
        System.out.println("Enter calculations in the format: number operator number");
        System.out.println("Supported operators: +, -, x, /, %, ^");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("\nEnter calculation: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid format. Please use: number operator number.");
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
                    case "x":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            System.out.println("Error: Cannot divide by zero.");
                            continue;
                        }
                        break;
                    case "%":
                        result = num1 % num2;
                        break;
                    case "^":
                        result = Math.pow(num1, num2);
                        break;
                    default:
                        System.out.println("Invalid operator. Supported operators: +, -, x, /, %, ^.");
                        continue;
                }
                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format.");
            } catch (Exception e) {
                System.out.println("Error: Something went wrong.");
            }
        }

        scanner.close();
    }
}
