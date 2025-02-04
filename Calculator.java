import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*********************Calculator**************************");
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();
        System.out.println("Enter: ");
        System.out.println("1 for Addition");
        System.out.println("2 for Subtraction");
        System.out.println("3 for division");
        System.out.println("4 for multiplication");
        System.out.print(">>>");
        double operator = sc.nextDouble();

        if (operator == 1){
            System.out.println("Result "+ (num1+num2));
        }else if (operator == 2) {
            System.out.println("Result "+ (num1-num2));
        }else if(operator == 3 && num2 != 0){
            System.out.println("Result "+ (num1/num2));
        }else if(operator == 4){
            System.out.println("Result "+ (num1*num2));
        }else if(num2 == 0){
            System.out.println("Error! Division by zero is not allowed");
        }
        
    }
}