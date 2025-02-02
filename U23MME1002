public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String continueCalculation;

    do {
        System.out.println("Eriobu's Calculator");
        System.out.println("-------------------");

        double num1 = getNumberFromUser (scanner, "Enter the first number: ");
        double num2 = getNumberFromUser (scanner, "Enter the second number: ");

        System.out.println("\nResults:");
        System.out.println("--------");

        performAddition(num1, num2);
        performSubtraction(num1, num2);
        performMultiplication(num1, num2);
        performDivision(num1, num2);

        System.out.print("Do you want to perform another calculation? (yes/no): ");
        continueCalculation = scanner.next();
    } while (continueCalculation.equalsIgnoreCase("yes"));

    scanner.close();
}
