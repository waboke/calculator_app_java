import java.util.Scanner;
public class Timi {
    public static void main(String[] args){
        Scanner accept = new Scanner(System.in);
        
        System.out.println("choose your operation: (+ , - , / , * , % ) ");
        String choice = accept.nextLine();
        
        double a, b , add, sub, div, mul, mod;
        System.out.print("Enter your first number: ");
         a = accept.nextDouble();
        System.out.print("Enter your second number: ");
         b = accept.nextDouble();
        
        add= a+b;
        sub= a-b;
        div = a/b;
        mul = a*b;
        mod = a%b;
        System.out.println("The Result is: ");
        
        switch (choice) {   
            case "+":
            System.out.println(a + " + " +b +" = " + add);
            break;
            case "-":
            System.out.println(a+ " - "+ b + " = "+ sub);
            break;
            case "/":
            if(b!=0){
                System.out.println(a+" / "+b+" = "+div);
            }
            else{
                System.out.println("Error");
            }
            break;
            case "*":
            System.out.println(a+" × "+b+" = " + mul);
            break;
            case "%":
            System.out.println(a+" % "+b+" = "+ mod);
            break;
            default:
            System.out.println("Invalid choice");
        }
        
    }
    
    
    
}