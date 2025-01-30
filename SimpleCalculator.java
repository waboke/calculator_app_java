import java.util.Scanner;
public class SimpleCalculator {
    public static void main(String [] arguments) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();

        System.out.println("Choose Operator: ");
        System.out.println("1 - Add \n2 - Subtract \n3 - Multiply \n4 - Divide");
        Syestem.out.print(">>> ")
        int operator = sc.nextInt();

        int result = 0;
        switch(operator) {
            case 1:
                result = n1 + n2;
                break;
            case 2:
                result = n1 - n2;
                break;
            case 3:
                result = n1 * n2;
                break;
            case 4:
                if (n2 != 0){
                    result = n1/n2;
                }else{
                    System.out.print("Error Cannot Divide by 0");
                    return;
                }
                break;
            default:
                System.out.print("Invalid Operator");
                return;
        }
        System.out.print(result);
    }
}
