import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ScientificCalculator extends JFrame implements ActionListener {

    private JTextField display;
    private String currentInput = "";
    private boolean isRadians = false;
    private boolean clearDisplayOnNextInput = false;

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 600));

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        display.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 5, 5, 5)); // Grid layout, 5 columns, dynamic rows
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String[] buttonLabels = {
                "AC", "C", "%", "/", "*",
                "7", "8", "9", "-", "(",
                "4", "5", "6", "+", ")",
                "1", "2", "3", "^", "√",
                "0", ".", "=", "π", "e",
                "sin", "cos", "tan", "log", "ln",
                "sin⁻¹", "cos⁻¹", "tan⁻¹", "10^x", "e^x",
                "x!", "x^y", "n√x", "Rad/Deg",
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 16));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (clearDisplayOnNextInput) {
            currentInput = "";
            display.setText("");
            clearDisplayOnNextInput = false;
        }

        switch (command) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
                currentInput += command;
                display.setText(currentInput);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
            case "^":
                currentInput += command;
                display.setText(currentInput);
                break;
            case "(":
            case ")":
                currentInput += command;
                display.setText(currentInput);
                break;
            case "π":
                currentInput += Math.PI;
                display.setText(currentInput);
                break;
            case "e":
                currentInput += Math.E;
                display.setText(currentInput);
                break;
            case "√":
                currentInput += "sqrt(";
                display.setText(currentInput);
                break;
            case "log":
                currentInput += "log10(";
                display.setText(currentInput);
                break;
            case "ln":
                currentInput += "ln(";
                display.setText(currentInput);
                break;
            case "sin":
                currentInput += "sin(";
                display.setText(currentInput);
                break;
            case "cos":
                currentInput += "cos(";
                display.setText(currentInput);
                break;
            case "tan":
                currentInput += "tan(";
                display.setText(currentInput);
                break;
            case "sin⁻¹":
                currentInput += "asin(";
                display.setText(currentInput);
                break;
            case "cos⁻¹":
                currentInput += "acos(";
                display.setText(currentInput);
                break;
            case "tan⁻¹":
                currentInput += "atan(";
                display.setText(currentInput);
                break;
            case "10^x":
                currentInput += "pow10(";
                display.setText(currentInput);
                break;
            case "e^x":
                currentInput += "exp(";
                display.setText(currentInput);
                break;
            case "x!":
                currentInput += "fact(";
                display.setText(currentInput);
                break;
            case "x^y":
                currentInput += "^("; // Using ^ as operator for x^y in input string
                display.setText(currentInput);
                break;
            case "n√x":
                currentInput += "nrt("; // nrt(n, x) for nth root of x
                display.setText(currentInput);
                break;
            case "Rad/Deg":
                isRadians = !isRadians;
                ((JButton) e.getSource()).setText(isRadians ? "Radians" : "Degrees"); // Toggle button text
                break;
            case "=":
                try {
                    String result = evaluateExpression(currentInput);
                    display.setText(result);
                    currentInput = result;
                    clearDisplayOnNextInput = true; // Clear after showing result
                } catch (ArithmeticException ex) {
                    display.setText("Error: " + ex.getMessage());
                    currentInput = "";
                    clearDisplayOnNextInput = true;
                } catch (Exception ex) {
                    display.setText("Error: Invalid Expression");
                    currentInput = "";
                    clearDisplayOnNextInput = true;
                }
                break;
            case "C":
                currentInput = "";
                display.setText("0");
                break;
            case "AC":
                currentInput = "";
                display.setText("0");
                isRadians = false;
                // Reset Rad/Deg button text if needed, though it's probably better to keep the toggle state.
                for (Component comp : ((JPanel)getContentPane().getComponent(1)).getComponents()) { // A bit hacky to find the button
                    if (comp instanceof JButton && ((JButton) comp).getText().equals("Radians")) {
                        ((JButton) comp).setText("Degrees");
                        break;
                    } else if (comp instanceof JButton && ((JButton) comp).getText().equals("Degrees")) {
                        break; // Already in Degrees state, no need to change
                    }
                }

                break;
        }
    }

    private String evaluateExpression(String expression) {
        try {
            return String.valueOf(ShuntingYardCalculator.evaluate(expression, isRadians));
        } catch (Exception e) {
            throw new ArithmeticException(e.getMessage()); // Re-throw as ArithmeticException for display
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScientificCalculator::new);
    }
}


class ShuntingYardCalculator {

    public static double evaluate(String expression, boolean isRadians) {
        List<String> postfixTokens = infixToPostfix(expression);
        return evaluatePostfix(postfixTokens, isRadians);
    }

    private static List<String> infixToPostfix(String expression) {
        List<String> postfixTokens = new ArrayList<>();
        Stack<String> operatorStack = new Stack<>();
        StringBuilder numberBuffer = new StringBuilder();
        StringBuilder functionBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                numberBuffer.append(c);
            } else if (Character.isLetter(c)) {
                functionBuffer.append(c);
            } else {
                // Process any pending number
                if (numberBuffer.length() > 0) {
                    postfixTokens.add(numberBuffer.toString());
                    numberBuffer.setLength(0);
                }

                // Process any pending function name
                if (functionBuffer.length() > 0) {
                    operatorStack.push(functionBuffer.toString());
                    functionBuffer.setLength(0);
                }

                if (c == '(') {
                    operatorStack.push("(");
                } else if (c == ')') {
                    boolean foundMatch = false;
                    while (!operatorStack.isEmpty()) {
                        String top = operatorStack.pop();
                        if (top.equals("(")) {
                            foundMatch = true;
                            // If there's a function on top of the stack, add it to output
                            if (!operatorStack.isEmpty() && isFunction(operatorStack.peek())) {
                                postfixTokens.add(operatorStack.pop());
                            }
                            break;
                        } else {
                            postfixTokens.add(top);
                        }
                    }
                    if (!foundMatch) {
                        throw new IllegalArgumentException("Mismatched parentheses");
                    }
                } else if (c == ',') {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        postfixTokens.add(operatorStack.pop());
                    }
                } else if (isOperator(String.valueOf(c))) {
                    String operator = String.valueOf(c);
                    while (!operatorStack.isEmpty() && isOperator(operatorStack.peek()) &&
                            getPrecedence(operatorStack.peek()) >= getPrecedence(operator)) {
                        postfixTokens.add(operatorStack.pop());
                    }
                    operatorStack.push(operator);
                }
            }
        }

        // Process any remaining number or function
        if (numberBuffer.length() > 0) {
            postfixTokens.add(numberBuffer.toString());
        }
        if (functionBuffer.length() > 0) {
            operatorStack.push(functionBuffer.toString());
        }

        // Pop remaining operators
        while (!operatorStack.isEmpty()) {
            String op = operatorStack.pop();
            if (op.equals("(")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            postfixTokens.add(op);
        }

        return postfixTokens;
    }



    private static double evaluatePostfix(List<String> postfixTokens, boolean isRadians) {
        Stack<Double> valueStack = new Stack<>();

        for (String token : postfixTokens) {
            if (isNumber(token)) {
                valueStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (valueStack.size() < 2) throw new IllegalArgumentException("Invalid expression");
                double operand2 = valueStack.pop();
                double operand1 = valueStack.pop();
                switch (token) {
                    case "+": valueStack.push(operand1 + operand2); break;
                    case "-": valueStack.push(operand1 - operand2); break;
                    case "*": valueStack.push(operand1 * operand2); break;
                    case "/":
                        if (operand2 == 0) throw new ArithmeticException("Division by zero");
                        valueStack.push(operand1 / operand2);
                        break;
                    case "^": valueStack.push(Math.pow(operand1, operand2)); break;
                    case "%": valueStack.push(operand1 % operand2); break;
                    default: throw new IllegalArgumentException("Unknown operator: " + token);
                }
            } else if (isFunction(token)) {
                switch (token) {
                    case "sqrt":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        valueStack.push(Math.sqrt(valueStack.pop()));
                        break;
                    case "log10":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        valueStack.push(Math.log10(valueStack.pop()));
                        break;
                    case "ln":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        valueStack.push(Math.log(valueStack.pop()));
                        break;
                    case "sin":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        double sinValue = valueStack.pop();
                        valueStack.push(isRadians ? Math.sin(sinValue) : Math.sin(Math.toRadians(sinValue)));
                        break;
                    case "cos":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        double cosValue = valueStack.pop();
                        valueStack.push(isRadians ? Math.cos(cosValue) : Math.cos(Math.toRadians(cosValue)));
                        break;
                    case "tan":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        double tanValue = valueStack.pop();
                        valueStack.push(isRadians ? Math.tan(tanValue) : Math.tan(Math.toRadians(tanValue)));
                        break;
                    case "asin":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        double asinValue = valueStack.pop();
                        double resultAsin = Math.asin(asinValue);
                        valueStack.push(isRadians ? resultAsin : Math.toDegrees(resultAsin));
                        break;
                    case "acos":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        double acosValue = valueStack.pop();
                        double resultAcos = Math.acos(acosValue);
                        valueStack.push(isRadians ? resultAcos : Math.toDegrees(resultAcos));
                        break;
                    case "atan":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        double atanValue = valueStack.pop();
                        double resultAtan = Math.atan(atanValue);
                        valueStack.push(isRadians ? resultAtan : Math.toDegrees(resultAtan));
                        break;
                    case "pow10":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        valueStack.push(Math.pow(10, valueStack.pop()));
                        break;
                    case "exp":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        valueStack.push(Math.exp(valueStack.pop()));
                        break;
                    case "fact":
                        if (valueStack.isEmpty()) throw new IllegalArgumentException("Invalid expression");
                        valueStack.push(factorial(valueStack.pop()));
                        break;
                    case "nrt": // Expecting two values on stack: root index then base
                        if (valueStack.size() < 2) throw new IllegalArgumentException("Invalid expression for nth root");
                        double base = valueStack.pop();
                        double root = valueStack.pop();
                        if (root == 0) throw new ArithmeticException("Root index cannot be zero");
                        valueStack.push(Math.pow(base, 1.0 / root));
                        break;
                    default: throw new IllegalArgumentException("Unknown function: " + token);
                }
            }
        }

        if (valueStack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        return valueStack.pop();
    }


    private static boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token) || "^".equals(token) || "%".equals(token);
    }

    private static boolean isFunction(String token) {
        return "sqrt".equals(token) || "log10".equals(token) || "ln".equals(token) ||
               "sin".equals(token) || "cos".equals(token) || "tan".equals(token) ||
               "asin".equals(token) || "acos".equals(token) || "atan".equals(token) ||
               "pow10".equals(token) || "exp".equals(token) || "fact".equals(token) || "nrt".equals(token);
    }

    private static int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "%":
                return 2;
            case "^":
                return 3; // Exponentiation
            default:
                return 0;
        }
    }

    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static double factorial(double n) {
        if (n < 0) throw new IllegalArgumentException("Factorial of negative number");
        if (n > 20) return Double.POSITIVE_INFINITY; // To avoid overflow and for practical limits
        if (n == 0) return 1;
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}