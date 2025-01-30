import java.util.Scanner;

public class DavidCalculator {
    private double num1;
    private double num2;

    public DavidCalculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add() {
        return num1 + num2;
    }

    public double subtract() {
        return num1 - num2;
    }

    public double multiply() {
        return num1 * num2;
    }

    public double divide() {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        DavidCalculator calculator = new DavidCalculator(num1, num2);

        System.out.print("Enter a numerical operator (Add, Subtract, Multiply, Divide): ");
        String numerical_operator = scanner.next();

        switch (numerical_operator) {
            case "Add":
            case "+":
                System.out.println("Result: " + calculator.add());
                break;
            case "Subtract":
            case "-":
                System.out.println("Result: " + calculator.subtract());
                break;
            case "Multiply":
            case "*":
                System.out.println("Result: " + calculator.multiply());
                break;
            case "Divide":
            case "/":
                try {
                    System.out.println("Result: " + calculator.divide());
                } catch (ArithmeticException e) {
                    System.out.println("Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid numerical operator.");
                break;
        }

        scanner.close();
    }
}
