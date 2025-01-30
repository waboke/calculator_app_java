import java.util.Scanner;
//scanner utility library imported and ready for use

public class VictorCalculatorApp{
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to my Calculator App!");

            //Requesting the class of operation to be carried out
            System.out.println("1- addition\n2-subtraction\n3-multiplication\n4-division");

            //Receiving and storing user defined input
            System.out.print("Enter an operator " );
            int operator = scanner.nextInt();
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();
            
            double result;
            //using switch statement to lay out the conditionals for the operartions
            switch (operator) {
                case 1:
                    result = num1 + num2;
                    System.out.println("The result is: " + result);
                    break;
                case 2:
                    result = num1 - num2;
                    System.out.println("The result is: " + result);
                    break;
                case 3:
                    result = num1 * num2;
                    System.out.println("The result is: " + result);
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("The result is: " + result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator.");
            }
        }
    }
}