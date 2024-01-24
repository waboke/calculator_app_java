import java.util.Scanner;

class Maincalculator{
    public static void performAddition(int firstNumber, int secondNumber) {
        System.out.printf("%d + %d = %d", firstNumber, secondNumber, firstNumber+secondNumber);
    }
    public static void performSubtraction(int firstNumber, int secondNumber) {
        System.out.printf("%d - %d = %d", firstNumber, secondNumber, firstNumber-secondNumber);
    }
    public static void performMultiplication(int firstNumber, int secondNumber) {
        System.out.printf("%d x %d = %d", firstNumber, secondNumber, firstNumber*secondNumber);
    }
    public static void performDivision(int firstNumber, int secondNumber) throws Exception {
        // Handle divide by 0 edge case
        if (secondNumber == 0) throw new Exception("Cannot divide by 0");

        System.out.printf("%d / %d = %d", firstNumber, secondNumber, firstNumber/secondNumber);
    }


    public static void main(String[] args) throws Exception {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        int firstNumber, secondNumber;

        try {
            // Accept first number from command line
            System.out.println("Please enter first number");
            firstNumber = Integer.parseInt(in.nextLine());

            // Ensure provided number is a two-digit number
            if (firstNumber < 10 || firstNumber > 99) {
                throw new Exception("Please provide a two digit number");
            }

            // Accept second number from command line
            System.out.println("Please enter second number");
            secondNumber = Integer.parseInt(in.nextLine());

            // Ensure provided number is a two-digit number
            if (secondNumber < 10 || secondNumber > 99) {
                throw new Exception("Please provide a two digit number");
            }
        } catch (NumberFormatException err) {
            throw new Exception("Please enter a valid number");
        }

        System.out.println("Select operation by entering one of the following: (+,-,*,/)");

        // Obtain operation selection
        String selection = in.nextLine();

        switch (selection) {
            case "+":
                performAddition(firstNumber, secondNumber);
                break;
            case "-":
                performSubtraction(firstNumber, secondNumber);
                break;
            case "*":
                performMultiplication(firstNumber, secondNumber);
                break;
            case "/":
                performDivision(firstNumber, secondNumber);
                break;
            default:
                throw new Exception("Invalid operation");
        }
    }
}