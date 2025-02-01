import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subtractButton, multiplyButton, divideButton, equalButton, clearButton;

    Font font = new Font("Arial", Font.BOLD, 20);
    double number1, number2, result;
    char operation;

    Calculator() {
        createGUI();
    }

    public void createGUI() {
        frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setBounds(20, 20, 260, 40);
        textField.setFont(font);
        frame.add(textField);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        equalButton.addActionListener(this);
        clearButton.addActionListener(this);

        addButton.setFont(font);
        subtractButton.setFont(font);
        multiplyButton.setFont(font);
        divideButton.setFont(font);
        equalButton.setFont(font);
        clearButton.setFont(font);

        numberButtons[0].setBounds(20, 340, 60, 40);
        numberButtons[1].setBounds(20, 280, 60, 40);
        numberButtons[2].setBounds(80, 280, 60, 40);
        numberButtons[3].setBounds(140, 280, 60, 40);
        numberButtons[4].setBounds(20, 220, 60, 40);
        numberButtons[5].setBounds(80, 220, 60, 40);
        numberButtons[6].setBounds(140, 220, 60, 40);
        numberButtons[7].setBounds(20, 160, 60, 40);
        numberButtons[8].setBounds(80, 160, 60, 40);
        numberButtons[9].setBounds(140, 160, 60, 40);

        addButton.setBounds(200, 280, 60, 40);
        subtractButton.setBounds(200, 220, 60, 40);
        multiplyButton.setBounds(200, 160, 60, 40);
        divideButton.setBounds(200, 100, 60, 40);
        equalButton.setBounds(140, 340, 60, 40);
        clearButton.setBounds(80, 340, 60, 40);

        frame.add(numberButtons[0]);
        frame.add(numberButtons[1]);
        frame.add(numberButtons[2]);
        frame.add(numberButtons[3]);
        frame.add(numberButtons[4]);
        frame.add(numberButtons[5]);
        frame.add(numberButtons[6]);
        frame.add(numberButtons[7]);
        frame.add(numberButtons[8]);
        frame.add(numberButtons[9]);

        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(equalButton);
        frame.add(clearButton);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == addButton) {
            number1 = Double.parseDouble(textField.getText());
            operation = '+';
            textField.setText("");
        }

        if (e.getSource() == subtractButton) {
            number1 = Double.parseDouble(textField.getText());
            operation = '-';
            textField.setText("");
        }

        if (e.getSource() == multiplyButton) {
            number1 = Double.parseDouble(textField.getText());
            operation = '*';
            textField.setText("");
        }

        if (e.getSource() == divideButton) {
            number1 = Double.parseDouble(textField.getText());
            operation = '/';
            textField.setText("");
        }

        if (e.getSource() == equalButton) {
            number2 = Double.parseDouble(textField.getText());

            switch (operation) {
                case '+':
                    result = number1 + number2;
                    break;
                case '-':
                    result = number1 - number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
