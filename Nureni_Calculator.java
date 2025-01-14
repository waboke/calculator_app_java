import java.util.Scanner;

public class Nureni_Calculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input first number : ");
        double firstNumber= scanner.nextDouble();
  
        System.out.print("Input second number : ");
        double secondNumber= scanner.nextDouble();
            
        sum(firstNumber, secondNumber);      
        product(firstNumber, secondNumber);    
        division(firstNumber, secondNumber);      
        subtraction(firstNumber, secondNumber);      
        remainder(firstNumber, secondNumber);
    }

    static void sum(double firstInput, double secondInput){
        double sumTotal = firstInput + secondInput;
        System.out.println("Sum = " + sumTotal);
    }

    static void product(double firstInput, double secondInput){
        double product = firstInput * secondInput;
        System.out.println("Product = " + product);
    }
  
    static void division(double firstInput, double secondInput){
        if (secondInput == 0){
            System.out.println("Undefined");       
        }  
        else {
            double division = firstInput / secondInput;
            System.out.println("Division = " + division);
        }
    }

    static void subtraction(double firstInput, double secondInput){
        double difference=firstInput-secondInput;
        System.out.println("Difference = "+difference);
    }
 
    static void remainder(double firstInput, double secondInput){
        if (secondInput == 0){
            System.out.println("Cannot be divided by zero");       
        } 
        else {
            double modulus = firstInput % secondInput;
            System.out.println("Remainder = " + modulus);
        }
    }

}
