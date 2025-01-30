import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
Scanner scanner=new Scanner(System.in);
	System.out.println("Enter first number");int num1=scanner.nextInt();
	System.out.println("Enter second number");
	int num2=scanner.nextInt();
	int sum=num1+num2;
	int difference=num1-num2;
	int product=num1*num2;
	double division=num1/num2;
	System.out.println("num1+num2=" + sum);
	System.out.println("num1-num2=" + difference);
	System.out.println("num1*num2=" + product);
	System.out.println("num1/num2=" + division);	
	}
}
