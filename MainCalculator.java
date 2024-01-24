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

        System.out.printf("%d / %d = %d", firstNumber, secondNumber, firstNumber+secondNumber);
    }


    public static void main(String[] args) throws Exception {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        // Accept first number from command line
        System.out.println("Please enter first number");
        int firstNumber = Integer.parseInt(in.nextLine());

        // Accept second number from command line
        System.out.println("Please enter second number");
        int secondNumber = Integer.parseInt(in.nextLine());

        System.out.println("Select operation");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        // Obtain operation selection
        int selection = Integer.parseInt(in.nextLine());

        switch (selection) {
            case 1:
                performAddition(firstNumber, secondNumber);
                break;
            case 2:
                performSubtraction(firstNumber, secondNumber);
                break;
            case 3:
                performMultiplication(firstNumber, secondNumber);
                break;
            case 4:
                performDivision(firstNumber, secondNumber);
                break;
            default:
                throw new Exception("Invalid operation");
        }
    }
}