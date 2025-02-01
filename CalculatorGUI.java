import javax.swing.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField number1Field, number2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        number1Field = new JTextField();
        number1Field.setBounds(50, 20, 80, 30);
        add(number1Field);

        number2Field = new JTextField();
        number2Field.setBounds(150, 20, 80, 30);
        add(number2Field);

        addButton = new JButton("+");
        addButton.setBounds(50, 60, 50, 30);
        addButton.addActionListener(this);
        add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(110, 60, 50, 30);
        subtractButton.addActionListener(this);
        add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.setBounds(170, 60, 50, 30);
        multiplyButton.addActionListener(this);
        add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.setBounds(230, 60, 50, 30);
        divideButton.addActionListener(this);
        add(divideButton);

        resultField = new JTextField();
        resultField.setBounds(50, 100, 230, 30);
        resultField.setEditable(false);
        add(resultField);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultField.setText("Error: Division by zero");
                    return;
                }
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
