import java.util.Scanner;

public class DanielCalculator {

    public static void main(String[] args) {

        Scanner scannerInput = new Scanner(System.in);

        char operation;
        double number1 , number2;        
        double results;

        // Choosing an operand
        System.out.print("Choose an Operation => +, - , * , / , % : ");        
        operation = scannerInput.next().charAt(0);

        // Showing you what operation ypu choose
        switch(operation) {
            case '+':
            System.out.println("You choose addition");
            break;
            case '-':
            System.out.println("You choose subtraction");
            break;
            case '*':
            System.out.println("You choose multiplication");
            break;
            case '/':
            System.out.println("You choose division");
            break;
            case '%':
            System.out.println("You choose modulus");
            break;
        }

        // Accepts the first user input
        System.out.print("Enter First Number : ");
        number1 = scannerInput.nextDouble();

        // Accepts the Second user input
        System.out.print("Enter Second Number : ");
        number2 = scannerInput.nextDouble();

        // Print out the result
        System.out.println("\nResults:");
        System.out.println("--------");        

        // Performing the calculation
        switch(operation) {
            case '+':
                results = number1 + number2;
                System.out.println(number1 + " " + operation + " " + number2 + " = " + results);
                break;

            case '-':
                results = number1 -  number2;
                System.out.println(number1 + " " + operation + " " + number2 + " = " + results);
                break;

            case '*':
                results = number1 * number2;
                System.out.println(number1 + " " + operation + " " + number2 + " = " + results);
                break;

            case '/': 
                if(number2 == 0) {
                    System.out.println("Not divisible by " + number2);                    
                } else {
                    results = number1 / number2;
                    System.out.println(number1 + " " + operation + " " + number2 + " = " + results);
                }
                break;

            case '%':
                results = number1 % number2;
                System.out.println(number1 + " " + operation + " " + number2 + " = " + results);
                break;

            default:
                System.out.println("Invalid Operation!!");                
                break;
        }

        scannerInput.close();

    }

}
