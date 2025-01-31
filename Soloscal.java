import java.util.Scanner;

public class Soloscal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;

        System.out.println("SOLOSCAL");
        System.out.println("Supported operators: +, -, *, /, %, ^");
        

        while (true) {
            System.out.print("\nEnter calculation: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid format. Please use:space in between operation.");
                continue;
            }

            try {
                double num1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double num2 = Double.parseDouble(parts[2]);

                switch (operator) {
                    case "+":
                        result = num1+num2;
                        break;
                    case "-":
                        result = num1-num2;
                        break;
                    case "*":
                        result = num1*num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1/num2;
                        } else {
                            System.out.println("Error: Cannot divide by zero.");
                            continue;
                        }
                        break;
                    case "%":
                        result = num1%num2;
                        break;
                    case "^":
                        result = Math.pow(num1,num2);
                        break;
                    default:
                        System.out.println("Invalid operator. Supported operators: +, -, *, /, %, ^.");
                        continue;
                }
                System.out.println("Ans: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format.");
            } catch (Exception e) {
                System.out.println("Error: Something went wrong.");
            }
        }

        scanner.close();
    }
                }
