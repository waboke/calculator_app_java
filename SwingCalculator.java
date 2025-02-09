import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalculator {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Calculator");
        JTextField textField = new JTextField();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        frame.add(panel, BorderLayout.CENTER);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            panel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    
                    if (command.charAt(0) == '=') {
                        try {
                            double result = eval(textField.getText());
                            textField.setText(String.valueOf(result));
                        } catch (Exception ex) {
                            textField.setText("Error");
                        }
                    } else {
                        textField.setText(textField.getText() + command);
                    }
                }
            });
        }

        frame.setVisible(true);
    }

    // Simple method to evaluate the expression (This is just a basic implementation)
    public static double eval(String expression) {
        String[] tokens = expression.split(" ");
        double num1 = Double.parseDouble(tokens[0]);
        double num2 = Double.parseDouble(tokens[2]);
        String operator = tokens[1];
        
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new UnsupportedOperationException("Unsupported operator");
        }
    }
}
