import java.util.Scanner;

public class SwingCalculator {

    public static void main(String[] args) {
        // Create Scanner object for input
        Scanner scanner = new Scanner(System.in);
        
        // Display introductory message
        System.out.println("Pendulum Swing Calculator");

        // Get the length of the pendulum from the user
        System.out.print("Enter the length of the pendulum (in meters): ");
        double length = scanner.nextDouble();

        // Validate the input
        if (length <= 0) {
            System.out.println("Length must be a positive number.");
        } else {
            // Constants
            final double g = 9.81; // Gravitational constant (m/s^2)

            // Calculate the period (T) of the pendulum: T = 2π√(L / g)
            double period = 2 * Math.PI * Math.sqrt(length / g);

            // Calculate the frequency (f) of the pendulum: f = 1 / T
            double frequency = 1 / period;

            // Display the results
            System.out.println("\nCalculated Results:");
            System.out.printf("Period (T) of the pendulum: %.2f seconds%n", period);
            System.out.printf("Frequency (f) of the pendulum: %.2f Hz%n", frequency);
        }

        // Close the scanner object
        scanner.close();
    }
}
