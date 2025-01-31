import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import javax.swing.*;

public class Casiocalculator extends JFrame {
    private JTextField display; // Display for inputs and results
    private String currentInput = ""; // Stores the current input
    private boolean isRadians = true; // Default angle unit
    private double memory = 0; // Memory storage

    // Constructor to set up the GUI
    public Casiocalculator() {
        // Frame settings
        setTitle("Casio Scientific Calculator");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display panel
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 5, 5, 5));

        // Button labels (grouped logically)
        String[] buttons = {
            "MC", "MR", "M+", "M-", "C",
            "sin", "cos", "tan", "π", "√",
            "asin", "acos", "atan", "e", "x²",
            "log", "ln", "!", "^", "1/x",
            "7", "8", "9", "/", "%",
            "4", "5", "6", "*", "(-)",
            "1", "2", "3", "-", "RAD",
            "0", ".", "=", "+", "DEG"
        };

        // Add buttons to the panel
        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Show the frame
        setVisible(true);
    }

    // Action listener for button clicks
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "C" -> {
                    currentInput = "";
                    display.setText("");
                }
                case "=" -> {
                    try {
                        double result = evaluate(currentInput);
                        display.setText(String.valueOf(result));
                        currentInput = ""; // Reset after calculation
                    } catch (Exception ex) {
                        display.setText("Error");
                        currentInput = "";
                    }
                }
                case "RAD" -> {
                    isRadians = true;
                    display.setText("RAD");
                }
                case "DEG" -> {
                    isRadians = false;
                    display.setText("DEG");
                }
                case "MC" -> memory = 0;
                case "MR" -> display.setText(String.valueOf(memory));
                case "M+" -> memory += Double.parseDouble(display.getText());
                case "M-" -> memory -= Double.parseDouble(display.getText());
                case "π" -> appendInput(String.valueOf(Math.PI));
                case "e" -> appendInput(String.valueOf(Math.E));
                case "x²" -> calculateUnary(value -> Math.pow(value, 2));
                case "√" -> calculateUnary(Math::sqrt);
                case "1/x" -> calculateUnary(value -> 1 / value);
                case "sin", "cos", "tan", "asin", "acos", "atan" -> calculateTrig(command);
                case "log" -> calculateUnary(Math::log10);
                case "ln" -> calculateUnary(Math::log);
                case "!" -> calculateFactorial();
                case "(-)" -> toggleSign();
                default -> appendInput(command); // Default append for numbers and operators
            }
        }
    }

    // Appends the input to the current expression
    private void appendInput(String input) {
        currentInput += input;
        display.setText(currentInput);
    }

    // Evaluates unary functions like √, log, etc.
    private void calculateUnary(UnaryOperator operator) {
        try {
            double value = Double.parseDouble(display.getText());
            double result = operator.apply(value);
            display.setText(String.valueOf(result));
            currentInput = "";
        } catch (Exception ex) {
            display.setText("Error");
            currentInput = "";
        }
    }
// Handles trigonometric calculations
private void calculateTrig(String func) {
    try {
        double value = Double.parseDouble(currentInput); // Use the currentInput for calculation
        if (!isRadians) value = Math.toRadians(value);  // Convert to radians if the mode is in degrees

        double result = switch (func) {
            case "sin" -> Math.sin(value);
            case "cos" -> Math.cos(value);
            case "tan" -> Math.tan(value);
            case "asin" -> Math.toDegrees(Math.asin(value)); // Outputs in degrees if not radians
            case "acos" -> Math.toDegrees(Math.acos(value));
            case "atan" -> Math.toDegrees(Math.atan(value));
            default -> throw new IllegalArgumentException("Invalid function");
        };

        // Display the result and reset input
        display.setText(String.valueOf(result));
        currentInput = "";
    } catch (NumberFormatException ex) {
        display.setText("Invalid Input");
        currentInput = "";
    } catch (Exception ex) {
        display.setText("Error");
        currentInput = "";
    }
}
    // Calculates the factorial of a number
    private void calculateFactorial() {
        try {
            int value = Integer.parseInt(display.getText());
            if (value < 0) throw new IllegalArgumentException();
            int result = 1;
            for (int i = 1; i <= value; i++) result *= i;
            display.setText(String.valueOf(result));
            currentInput = "";
        } catch (Exception ex) {
            display.setText("Error");
            currentInput = "";
        }
    }

    // Toggles the sign of the number
    private void toggleSign() {
        try {
            double value = Double.parseDouble(display.getText());
            value = -value;
            display.setText(String.valueOf(value));
            currentInput = String.valueOf(value);
        } catch (Exception ex) {
            display.setText("Error");
            currentInput = "";
        }
    }

    // Evaluates the mathematical expression
    private double evaluate(String expression) throws Exception {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;
                numbers.push(Double.parseDouble(sb.toString()));
            } else if ("+-*/^".indexOf(c) >= 0) {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    double b = numbers.pop();
                    double a = numbers.pop();
                    numbers.push(applyOperation(a, b, operators.pop()));
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            double b = numbers.pop();
            double a = numbers.pop();
            numbers.push(applyOperation(a, b, operators.pop()));
        }

        return numbers.pop();
    }

    // Operator precedence
    private int precedence(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> 0;
        };
    }

    // Applies the operation between two numbers
    private double applyOperation(double a, double b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case '^' -> Math.pow(a, b);
            default -> 0;
        };
    }

    // Main method to launch the calculator
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Casiocalculator::new);
    }

    // Functional interface for unary operations
    @FunctionalInterface
    interface UnaryOperator {
        double apply(double value);
    }
}