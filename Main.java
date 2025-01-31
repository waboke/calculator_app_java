package myfirstprogram;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int firstNum=0;
		int secondNum=0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please input first integer:");
		firstNum=scan.nextInt();
		
		System.out.println("Please input second integer:");
		secondNum=scan.nextInt();
		
		int operator;
		double answer=0;
		
		System.out.println("Which operator:");
		System.out.println("1. +");
		System.out.println("2. -");
		System.out.println("3. *");
		System.out.println("4. %");
		
		
		
		operator=scan.nextInt();
		
		switch(operator)
		{
		case 1: answer = firstNum + secondNum;
		break;
		case 2: answer = firstNum - secondNum;
		break;
		case 3: answer = firstNum * secondNum;
		break;
		case 4: answer = firstNum % secondNum;
		break;
		}
		
		System.out.println("Answer is:" + answer);
		
		}
	
	
		

}
