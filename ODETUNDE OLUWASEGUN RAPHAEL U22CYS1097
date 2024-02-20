class Maincalculator{
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

        try {
            int num1 = getTwoDigitNumber(scanner);
            char operator = getOperator(scanner);
            int num2 = getTwoDigitNumber(scanner);

            int result = switch (operator) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> (num2 == 0) ? throw new IllegalArgumentException("Cannot divide by zero.") : num1 / num2;
                default -> throw new IllegalArgumentException("Invalid operator.");
            };

            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int getTwoDigitNumber(Scanner scanner) {
        int number = scanner.nextInt();
        if (number < 10 || number > 99) throw new IllegalArgumentException("Please enter a valid two-digit number.");
        return number;
    }

    private static char getOperator(Scanner scanner) {
        char operator = scanner.next().charAt(0);
        if (operator != '+' && operator != '-' && operator != '*' && operator != '/')
            throw new IllegalArgumentException("Invalid operator. Please enter +, -, *, or /.");
        return operator;
    }
}
    
}
