import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCalculator extends JFrame implements ActionListener {

    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton;
    private JButton clearButton;
    private double operand1;
    private String operator;

    public SwingCalculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);  // Prevent direct editing
        add(display, BorderLayout.NORTH);


        // Number buttons
        JPanel numberPanel = new JPanel(new GridLayout(4, 3));
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberPanel.add(numberButtons[i]);
        }
        numberPanel.add(new JButton("")); // Placeholder for better layout
        numberPanel.add(numberButtons[0]); // Zero button again for better layout
        numberPanel.add(new JButton(".")); // Decimal point
        add(numberPanel, BorderLayout.CENTER);

        // Operator buttons
        JPanel operatorPanel = new JPanel(new GridLayout(4, 1));
        operatorButtons = new JButton[4];
        String[] ops = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            operatorButtons[i] = new JButton(ops[i]);
            operatorButtons[i].addActionListener(this);
            operatorPanel.add(operatorButtons[i]);
        }
        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        clearButton = new JButton("C");
        clearButton.addActionListener(this);

        JPanel controlPanel = new JPanel(new GridLayout(2,1));
        controlPanel.add(equalsButton);
        controlPanel.add(clearButton);

        operatorPanel.add(controlPanel); //Add equals and clear to operator panel


        add(operatorPanel, BorderLayout.EAST);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            if (display.getText().equals("0")) {
                display.setText(command);
            } else {
                display.setText(display.getText() + command);
            }
        } else if (command.equals(".")) {
          if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
          }
        } else if (command.equals("C")) {
            display.setText("0");
            operand1 = 0;
            operator = null;
        } else if (command.equals("=")) {
            try {
                double operand2 = Double.parseDouble(display.getText());
                double result = calculate(operand1, operand2, operator);
                display.setText(String.valueOf(result));
                operand1 = result; // Store result for chaining operations
                operator = null;
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (command.matches("[+\\-*/]")) {
            try {
              operand1 = Double.parseDouble(display.getText());
              operator = command;
              display.setText("0");
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
    }

    private double calculate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero"); // Handle division by zero
                }
                return operand1 / operand2;
            default:
                return operand2; // If no operator is set, return the second operand (e.g., for initial input)
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingCalculator());
    }
}
