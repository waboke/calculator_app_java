import java.util.Scanner;
 
public class TwoDigitCalculator {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
 
       // Input
       System.out.print("Enter the first digit: ");
       int num1 = scanner.nextInt();
 
       System.out.print("Enter the operator (+, -, *, /): ");
       char operator = scanner.next().charAt(0);
 
       System.out.print("Enter the second digit: ");
       int num2 = scanner.nextInt();
 
       // Calculation and Output
       switch (operator) {
           case '+':
               System.out.println("Result: " + (num1 + num2));
               break;
           case '-':
               System.out.println("Result: " + (num1 - num2));
               break;
           case '*':
               System.out.println("Result: " + (num1 * num2));
               break;
           case '/':
               if (num2 != 0) {
                   System.out.println("Result: " + ((double) num1 / num2));
               } else {
                   System.out.println("Cannot divide by zero!");
               }
               break;
           default:
               System.out.println("Invalid operator!");
       }
 
       scanner.close();
   }
}
