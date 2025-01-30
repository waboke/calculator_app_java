public class Abbascalculator {
    public static void main(String[] args) {
        double num1 = 10, num2 = 5; // Example numbers
        char operator = '+'; // Example operator

        double result;
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = (num2 != 0) ? num1 / num2 : Double.NaN; break;
            default: result = Double.NaN; // NaN for invalid operator
        }

        System.out.println("Result: " + result);
    }
}
