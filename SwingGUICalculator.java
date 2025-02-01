import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SwingCalculator {
    private JFrame frame;
    private JTextField textField;
    private StringBuilder currentInput;
    private double firstNumber;
    private String operator;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                SwingCalculator window = new SwingCalculator();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SwingCalculator() {
        currentInput = new StringBuilder();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Calculator");
        frame.setBounds(100, 100, 400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 32));
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false);
        frame.getContentPane().add(textField, BorderLayout.NORTH);
        textField.setColumns(10);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "x²", "^", "del"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("C".equals(command)) {
                currentInput.setLength(0);
                textField.setText("");
            } else if ("del".equals(command)) {
                if (currentInput.length() > 0) {
                    currentInput.deleteCharAt(currentInput.length() - 1);
                    textField.setText(currentInput.toString());
                }
            } else if ("=".equals(command)) {
                try {
                    double result = evaluate(currentInput.toString());
                    textField.setText(String.valueOf(result));
                    currentInput.setLength(0);
                    currentInput.append(result);
                } catch (Exception ex) {
                    textField.setText("Error");
                    currentInput.setLength(0);
                }
            } else if ("+".equals(command) || "-".equals(command) || "*".equals(command) || "/".equals(command) || "^".equals(command)) {
                firstNumber = Double.parseDouble(currentInput.toString());
                operator = command;
                currentInput.setLength(0);
            } else if ("x²".equals(command)) {
                try {
                    double number = Double.parseDouble(currentInput.toString());
                    double result = Math.pow(number, 2);
                    textField.setText(String.valueOf(result));
                    currentInput.setLength(0);
                    currentInput.append(result);
                } catch (Exception ex) {
                    textField.setText("Error");
                    currentInput.setLength(0);
                }
            } else {
                currentInput.append(command);
                textField.setText(currentInput.toString());
            }
        }
    }

    private double evaluate(String expression) {
        double result = 0.0;
        if (operator != null && !operator.isEmpty()) {
            double secondNumber = Double.parseDouble(expression);
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        textField.setText("Error");
                    }
                    break;
                case "^":
                    result = Math.pow(firstNumber, secondNumber);
                    break;
            }
        }
        return result;
    }
}
