import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalculator extends JFrame implements ActionListener {
    // Create a frame
    private JFrame frame;

    // Create a textfield
    private JTextField textField;

    // Store operator and operands
    private String operator, operand1, operand2;

    // Constructor
    public SwingCalculator() {
        operator = "";
        operand1 = operand2 = "";

        // Create a frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);

        // Create a textfield
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        // Create number buttons and some operators
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            numberButtons[i].addActionListener(this);
        }

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton dotButton = new JButton(".");
        JButton equButton = new JButton("=");

        // Add Action Listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        dotButton.addActionListener(this);
        equButton.addActionListener(this);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(dotButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add textfield and panel to frame
        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // If the command is a number or dot
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.charAt(0) == '.') {
            if (!operator.isEmpty()) {
                operand2 += command;
            } else {
                operand1 += command;
            }
            textField.setText(textField.getText() + command);
        } else if (command.charAt(0) == '=') {
            double result = 0;

            switch (operator) {
                case "+":
                    result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
                    break;
                case "-":
                    result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
                    break;
                case "*":
                    result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));
                    break;
                case "/":
                    result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
                    break;
            }

            textField.setText(String.valueOf(result));
            operand1 = String.valueOf(result);
            operator = operand2 = "";
        } else {
            if (operator.isEmpty() || operand2.isEmpty()) {
                operator = command;
            } else {
                double result = 0;

                switch (operator) {
                    case "+":
                        result = (Double.parseDouble(operand1) + Double.parseDouble(operand2));
                        break;
                    case "-":
                        result = (Double.parseDouble(operand1) - Double.parseDouble(operand2));
                        break;
                    case "*":
                        result = (Double.parseDouble(operand1) * Double.parseDouble(operand2));
                        break;
                    case "/":
                        result = (Double.parseDouble(operand1) / Double.parseDouble(operand2));
                        break;
                }

                operand1 = String.valueOf(result);
                operator = command;
                operand2 = "";
            }

            textField.setText(textField.getText() + command);
        }
    }

    public static void main(String[] args) {
        new SwingCalculator();
    }
}