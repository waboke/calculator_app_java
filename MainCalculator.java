import java.util.Scanner;

public class MainCalculator {
	public static void main(String[] args) {

		//scanner for getting input
		Scanner scanner = new Scanner(System.in);
		
		//getting the first number from user
		System.out.print("Enter first number : ");
		float num1 = scanner.nextFloat();
		
		//getting the operation to be performed
		System.out.print("Enter operation : ");
		String sign = scanner.next();
		
		//getting the second number
		System.out.print("Enter second number : ");
		float num2 = scanner.nextFloat();
		
		//variable for storing the result
		float result;
		
		//check the operation to determine the result 
		switch (sign) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "×":
				result = num1 * num2;
				break;
			case "÷":
				if (num2 != 0) {
					result = num1 / num2;
				}
				else {
					System.out.println("cannot divide by 0");
					return; 
				}
				break;
			case "%":
				result = num1 % num2;
				break;
			default:
				System.out.println("not a valid operation");
				return;	
		}
		System.out.println("Result = "  + result );
	}	
}
