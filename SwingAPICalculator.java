import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "SQ", "SQRT", "C", "CE"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("C")) {
            display.setText("");
            firstNumber = 0;
            secondNumber = 0;
            operator = "";
        } else if (command.equals("CE")) {
            display.setText("");
        } else if (command.equals("=")) {
            secondNumber = Double.parseDouble(display.getText());
            double result = calculate(firstNumber, secondNumber, operator);
            display.setText(String.valueOf(result));
            operator = "";
        } else if (command.equals("SQ")) {
            firstNumber = Double.parseDouble(display.getText());
            display.setText(String.valueOf(firstNumber * firstNumber));
        } else if (command.equals("SQRT")) {
            firstNumber = Double.parseDouble(display.getText());
            if (firstNumber < 0) {
                display.setText("Error");
            } else {
                display.setText(String.valueOf(Math.sqrt(firstNumber)));
            }
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            firstNumber = Double.parseDouble(display.getText());
            operator = command;
            display.setText("");
        } else {
            display.setText(display.getText() + command);
        }
    }

    private double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    return Double.NaN;
                }
            default:
                return 0;
        }
    }
}