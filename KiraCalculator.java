import java.util.Objects;
import java.util.Scanner;
public class KiraCalculator {
    public static void main(String[] args) {
        System.out.print("""
                Welcome to Kira's Calculator
                Enter any key to start the calculator: """);
        Scanner input = new Scanner(System.in);
        input.nextLine(); // The user is expected to type any character and press enter to continue to the calculator
        while (true) {  //loop the program as long as the user enters a character
            System.out.println("""
                             COMMAND LIST:
                    Use '+' for addition
                    Use '*' for multiplication
                    Use '-' for subtraction
                    Use '/' for division
                    Use '%' for remainder
                    Use '^' for raise to power (to calculate a raise to power of b; you can use a^(b^-1) to calculate the bth root of A)
                    Press Enter to carry out the calculation
                    Input your calculation, press enter after every variable or operand you input""");


            double a = getValidUserInput(input,"First Variable: ");
            input.nextLine();

            System.out.print("Operand: ");
            String operand = input.next().toLowerCase();

            if(Objects.equals(operand, "sqrt")){
                if(a > 0){
                double result = Math.sqrt(a);
                System.out.println("Result= " + result);
                }
                else{
                    System.out.print("Cannot calculate root of negative values");
                }
            }
            else {

                double b = getValidUserInput(input, "Second Variable: ");

                String result = switch (operand) {   //switch case containing all operations the computer can handle
                    case "+" -> String.valueOf(a + b);
                    case "-" -> String.valueOf(a - b);
                    case "*" -> String.valueOf(a * b);
                    case "/" -> {
                        if (b != 0) {
                            yield String.valueOf(a / b); // to return the value of the division of the two variables
                        } else {
                            yield "Error: Division by zero"; // used to handle the exception to the denominator being zero
                        }
                    }

                    case "%" -> String.valueOf(a % b);
                    case "^" -> String.valueOf(Math.pow(a, b));
                    default -> "Error: Invalid operator"; // handle invalid operators entered by the user
                };


                System.out.println("Result: " + result);
            }
            System.out.print("Type 'Quit' to exit the calculator or press Enter to continue: "); //typing the quit command serves as an off button for the program
            input.nextLine();

            String command = input.nextLine(); //takes input from the user

            if (command.equalsIgnoreCase("Quit")) { //entering command exits : any other key continues running the application
                break; //exiting the calculator program

            }
        }
        System.out.print("Thank you for using Kira's calculator");

    }

    private static double getValidUserInput(Scanner input, String promptMessage) {
        double userInput = 0;
        while (true) {
            System.out.print(promptMessage);
            if (input.hasNextDouble()) {
                userInput = input.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid decimal value.");
                input.next();
            }
        }
        return userInput;
    }
}

