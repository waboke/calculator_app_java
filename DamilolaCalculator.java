import java.util.Scanner;

public class DamilolaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Damilola's Calculator");
        System.out.println("Press Enter to start the calculator:");
        input.nextLine();

        System.out.println("COMMAND LIST:");
        System.out.println("  + : addition");
        System.out.println("  - : subtraction");
        System.out.println("  * : multiplication");
        System.out.println("  / : division");
        System.out.println("Input your calculation, press enter after every variable or operand you input");

        String command = "";
        while (!command.equalsIgnoreCase("quit")) {
            System.out.print("Enter your first variable: ");
            double a = input.nextDouble();
            input.nextLine(); // consume newline left-over

            System.out.print("Enter an operand: ");
            String operand = input.nextLine();

            System.out.print("Enter your second variable: ");
            double b = input.nextDouble();
            input.nextLine(); // consume newline left-over

            String result = switch (operand) {
                case "+" -> String.valueOf(a + b);
                case "-" -> String.valueOf(a - b);
                case "*" -> String.valueOf(a * b);
                case "/" -> {
                    if (b != 0) {
                        yield String.valueOf(a / b);
                    } else {
                        yield "Error: Division by zero";
                    }
                }
                default -> "Unexpected value: " + operand;
            };

            System.out.println("Result: " + result);

            System.out.print("Enter 'Quit' to exit the calculator, press any key to continue: ");
            command = input.nextLine();
        }
    }
}