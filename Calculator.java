import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        double num1 = sc.nextDouble();
        System.out.println("Enter the second number:");
        double num2 = sc.nextDouble();
        System.out.println("Enter the operator (+, -, *, /):");
        char operator = sc.next().charAt(0);
        switch(operator){
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
            if (num2==0){
                System.out.println("Can not divide by 0");
                break;
            }else{
                System.out.println("Result: " + (num1 / num2));
            }
            break;
            default:
            System.out.println("Invalid operator");
            break;
        }
    }
}