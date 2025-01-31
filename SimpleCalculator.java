import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton, equalButton, clearButton;
    private String operator;
    private double num1, num2;

    public SimpleCalculator() {
        // Create frame
        setTitle("Simple Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create input field
        inputField = new JTextField();
        inputField.setEditable(false);
        add(inputField, BorderLayout.NORTH);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            buttonPanel.add(numberButtons[i]);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalButton.addActionListener(this);
        clearButton.addActionListener(this);

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        
        buttonPanel.add(equalButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) {
                inputField.setText(inputField.getText() + i);
                return;
            }
        }

        if (e.getSource() == clearButton) {
            inputField.setText("");
            num1 = num2 = 0;
            operator = "";
            return;
        }

        if (!operator.isEmpty()) {
            num2 = Double.parseDouble(inputField.getText());
            switch (operator) {
                case "+":
                    num1 += num2;
                    break;
                case "-":
                    num1 -= num2;
                    break;
                case "*":
                    num1 *= num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        num1 /= num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                        return;
                    }
                    break;
            }
            inputField.setText(String.valueOf(num1));
            operator = "";
            return;
        }

        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(inputField.getText());
            switch (operator) {
                case "+":
                    num1 += num2;
                    break;
                case "-":
                    num1 -= num2;
                    break;
                case "*":
                    num1 *= num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        num1 /= num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero");
                        return;
                    }
                    break;
            }
            inputField.setText(String.valueOf(num1));
            operator = "";
            return;
        }

        if (e.getSource() == addButton) {
            operator = "+";
            num1 = Double.parseDouble(inputField.getText());
            inputField.setText("");
            return;
        }

        if (e.getSource() == subButton) {
            operator = "-";
            num1 = Double.parseDouble(inputField.getText());
            inputField.setText("");
            return;
        }

        if (e.getSource() == mulButton) {
            operator = "*";
            num1 = Double.parseDouble(inputField.getText());
            inputField.setText("");
            return;
        }

        if (e.getSource() == divButton) {
            operator = "/";
            num1 = Double.parseDouble(inputField.getText());
            inputField.setText("");
            return;
        }
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setVisible(true);
    }
}
