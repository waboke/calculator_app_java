import java.util.Scanner;

public class ConsoleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Console Calculator");
        System.out.println("Enter the first number:");
        double num1 = sc.nextDouble();
        
        System.out.println("Enter the second number:");
        double num2 = sc.nextDouble();
        
        System.out.println("Select an operation: +, -, *, /");
        char operator = sc.next().charAt(0);
        
        double result = 0;
        
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
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error! Division by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator!");
                return;
        }
        
        System.out.println("Result: " + result);
    }
}
