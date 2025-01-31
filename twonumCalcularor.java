import java.util.Scanner;

public class twonumCalcularor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double num1 = scanner.nextDouble();

        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();

        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        int operation = scanner.nextInt();

        double result = 0;

        switch (operation) {
            case 1:
                result = num1 + num2;
                System.out.println("num1 + num2 = " + result);
                break;
            case 2:
                result = num1 - num2;
                System.out.println("num1 - num2 = " + result);
                break;
            case 3:
                result = num1 * num2;
                System.out.println("num1 * num2 = " + result);
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("num1 / num2 = " + result);
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;
            default:
                System.out.println("Invalid operation");
        }
    }
}
