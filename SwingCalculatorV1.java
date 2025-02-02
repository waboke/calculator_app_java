import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SwingCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private JTextArea historyArea;
    private double num1, num2, result;
    private char operator;
    private ArrayList<String> history = new ArrayList<>();

    public SwingCalculator() {
        setTitle("Advanced Swing Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display Field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // History Panel
        historyArea = new JTextArea(5, 20);
        historyArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyArea);
        add(scrollPane, BorderLayout.EAST);

        // Buttons Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = { "7", "8", "9", "/", "√", "sin", "cos", "tan",
                             "4", "5", "6", "*", "^", "log", "C", "MR",
                             "1", "2", "3", "-", "=", "0", ".", "+" };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);

        // Keyboard Input Support
        display.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                if (Character.isDigit(keyChar) || keyChar == '.' || "+-*/^".indexOf(keyChar) != -1) {
                    display.setText(display.getText() + keyChar);
                } else if (keyChar == KeyEvent.VK_ENTER) {
                    calculateResult();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.matches("[0-9.]") || command.equals("MR")) {
                display.setText(display.getText() + command);
            } else if (command.equals("C")) {
                display.setText("");
                num1 = num2 = result = 0;
            } else if (command.equals("=")) {
                calculateResult();
            } else if (command.equals("√")) {
                num1 = Double.parseDouble(display.getText());
                result = Math.sqrt(num1);
                display.setText(String.valueOf(result));
                addToHistory("√(" + num1 + ") = " + result);
            } else if (command.equals("sin")) {
                num1 = Double.parseDouble(display.getText());
                result = Math.sin(Math.toRadians(num1));
                display.setText(String.valueOf(result));
                addToHistory("sin(" + num1 + ") = " + result);
            } else if (command.equals("cos")) {
                num1 = Double.parseDouble(display.getText());
                result = Math.cos(Math.toRadians(num1));
                display.setText(String.valueOf(result));
                addToHistory("cos(" + num1 + ") = " + result);
            } else if (command.equals("tan")) {
                num1 = Double.parseDouble(display.getText());
                result = Math.tan(Math.toRadians(num1));
                display.setText(String.valueOf(result));
                addToHistory("tan(" + num1 + ") = " + result);
            } else if (command.equals("log")) {
                num1 = Double.parseDouble(display.getText());
                result = Math.log10(num1);
                display.setText(String.valueOf(result));
                addToHistory("log(" + num1 + ") = " + result);
            } else {
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            }
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    private void calculateResult() {
        try {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result = num1 / num2;
                    break;
                case '^': result = Math.pow(num1, num2); break;
                default: throw new Exception("Invalid Operation");
            }
            display.setText(String.valueOf(result));
            addToHistory(num1 + " " + operator + " " + num2 + " = " + result);
        } catch (Exception ex) {
            display.setText("Error");
        }
    }

    private void addToHistory(String entry) {
        history.add(entry);
        historyArea.append(entry + "\n");
    }

    public static void main(String[] args) {
        SwingCalculator calculator = new SwingCalculator();
        calculator.setVisible(true);
    }
                }
