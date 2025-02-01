import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;
        
        while (true) {
            System.out.println("\nCommand_Line Based Calculator");
            System.out.println("Available operations: +, -, *, /, % (modulus)");
            System.out.println("Enter 'q' to quit");
            
            // Get first number
            System.out.print("Enter first number: ");
            if (!scanner.hasNextDouble()) {
                String input = scanner.next();
                if (input.equals("q")) {
                    break;
                }
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            num1 = scanner.nextDouble();
            
            // Get operator
            System.out.print("Enter operator: ");
            operator = scanner.next().charAt(0);
            
            if (operator == 'q') {
                break;
            }
            
            if (operator != '+' && operator != '-' && operator != '*' && 
                operator != '/' && operator != '%') {
                System.out.println("Invalid operator");
                continue;
            }
            
            // Get second number
            System.out.print("Enter second number: ");
            if (!scanner.hasNextDouble()) {
                String input = scanner.next();
                if (input.equals("q")) {
                    break;
                }
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            num2 = scanner.nextDouble();
            
            // Perform calculation
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero!");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                case '%':
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero!");
                        continue;
                    }
                    result = num1 % num2;
                    break;
                default:
                    System.out.println("Invalid operator");
                    continue;
            }
            
            System.out.printf("Result: %.2f %c %.2f = %.2f%n", 
                            num1, operator, num2, result);
        }
        
        System.out.println("Calculator closed.");
        scanner.close();
    }
}
