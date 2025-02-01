import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICalculator extends JFrame implements ActionListener {
    private JTextField textField;
    private double num1 = 0, num2 = 0;
    private char operator;

    public GUICalculator() {
        setTitle("GUI Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            textField.setText(textField.getText() + command);
        } else if (command.equals("C")) {
            textField.setText("");
            num1 = num2 = 0;
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    textField.setText(String.valueOf(num1 + num2));
                    break;
                case '-':
                    textField.setText(String.valueOf(num1 - num2));
                    break;
                case '*':
                    textField.setText(String.valueOf(num1 * num2));
                    break;
                case '/':
                    if (num2 != 0) {
                        textField.setText(String.valueOf(num1 / num2));
                    } else {
                        textField.setText("Error!");
                    }
                    break;
            }
        } else { // Operator (+, -, *, /)
            num1 = Double.parseDouble(textField.getText());
            operator = command.charAt(0);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new GUICalculator();
    }
}