import java.util.Scanner;

class Maincalculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number:");
        double firstNumber = scanner.nextDouble();

        System.out.println("Enter second number:");
        double secondNumber = scanner.nextDouble();

        System.out.println("Select operation (+, -, *, /):");
        char operation = scanner.next().charAt(0);

        double result;

        switch (operation) {
            case '+':
                result = add(firstNumber, secondNumber);
                System.out.printf("%.2f + %.2f = %.2f\n", firstNumber, secondNumber, result);
                break;
            case '-':
                result = subtract(firstNumber, secondNumber);
                System.out.printf("%.2f - %.2f = %.2f\n", firstNumber, secondNumber, result);
                break;
            case '*':
                result = multiply(firstNumber, secondNumber);
                System.out.printf("%.2f * %.2f = %.2f\n", firstNumber, secondNumber, result);
                break;
            case '/':
                try {
                    result = divide(firstNumber, secondNumber);
                    System.out.printf("%.2f / %.2f = %.2f\n", firstNumber, secondNumber, result);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid operation");
        }

        scanner.close();
    }
}
