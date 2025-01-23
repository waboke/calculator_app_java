import java.util.Scanner;

public class RodhiyaCalculator{
    public static void main(String[] args){

        //Cerating a scanner object for user input
        Scanner scanner= new Scanner(System.in);
        
        //Prompt the user to enter two values
        System.out.println("Enter the first number:");
            int num1= scanner.nextInt();

            System.out.println("Enter the second number:");
            int num2= scanner.nextInt();

        // Perform the five operations
        int addition= num1+num2;
        int subtraction= num1-num2;
        int multiplication= num1*num2;
        int division= num1/num2;
        int modulus= num2!=0?num1%num2:0;

        // Display the results
        System.out.println("Results of the operations :");
        System.out.println("Addition :" + addition);
        System.out.println("Subtraction :" + subtraction);
        System.out.println("multiplication :" + multiplication);

        if (num2!=0) {
            System.out.println("Division :" + division);
            System.out.println("Modulus :" + modulus);
            }

        else {
            System.out.println("Division and modulus cannot be performed (division by 0).");
        }

        // Close scanner
        scanner.close();
    }
}
