import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorApp {
    private final JFrame frame;
    private final JTextField textField;
    private String operator ="";
    private double num1 = 0, num2 = 0, result = 0;

    public CalculatorApp() {
        frame = new JFrame("Calculator");
        frame.setSize(300, 400);

frame.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textField = new JtextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));

textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));

button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static class Jframe {

        private static int EXIT_ON_CLOSE;

        public Jframe() {
        }
    }

    private static class JtextField extends JTextField {

        public JtextField() {
        }
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                textField.setText(textField.getText() + command);
            }
            else if ("/-*+".contains(command)) {
                operator = command;
                num1 = Double.parseDouble(textField.getText());

                textField.setText("");
            }
            else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "/" -> result = num1 / num2;
                    case "*" -> result = num1 * num2;
                    case "-" -> result = num1 - num2;
                    case "+" -> result = num1 + num2;
                }

                textField.setText(String.valueOf(result));
                operator = "";
            }
            else if (command.equals("C")) {
                textField.setText("");
                operator = "";
                num1 = num2 = result = 0;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorApp::new);
    }
}
