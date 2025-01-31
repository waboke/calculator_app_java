import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCalculator implements ActionListener {
    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[8];
    private String[] functionNames = {"+", "-", "*", "/", "=", "C", ".", "DEL"};
    
    private double num1, num2, result;
    private char operator;

    public SwingCalculator() {
        frame = new JFrame("Swing Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 20, 340, 50);
        textField.setEditable(false);
        frame.add(textField);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i] = new JButton(functionNames[i]);
            functionButtons[i].addActionListener(this);
        }

        JPanel panel = new JPanel();
        panel.setBounds(20, 90, 340, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(functionButtons[0]);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(functionButtons[1]);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(functionButtons[2]);

        panel.add(functionButtons[6]);
        panel.add(numberButtons[0]);
        panel.add(functionButtons[5]);
        panel.add(functionButtons[3]);

        frame.add(panel);

        functionButtons[4].setBounds(250, 400, 100, 40);
        functionButtons[7].setBounds(140, 400, 100, 40);
        frame.add(functionButtons[4]);
        frame.add(functionButtons[7]);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        for (int i = 0; i < functionButtons.length; i++) {
            if (e.getSource() == functionButtons[i]) {
                switch (functionNames[i]) {
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        num1 = Double.parseDouble(textField.getText());
                        operator = functionNames[i].charAt(0);
                        textField.setText("");
                        break;
                    case "=":
                        num2 = Double.parseDouble(textField.getText());
                        switch (operator) {
                            case '+': result = num1 + num2; break;
                            case '-': result = num1 - num2; break;
                            case '*': result = num1 * num2; break;
                            case '/': result = (num2 != 0) ? num1 / num2 : 0; break;
                        }
                        textField.setText(String.valueOf(result));
                        break;
                    case "C":
                        textField.setText("");
                        break;
                    case "DEL":
                        String text = textField.getText();
                        if (!text.isEmpty()) {
                            textField.setText(text.substring(0, text.length() - 1));
                        }
                        break;
                    case ".":
                        if (!textField.getText().contains(".")) {
                            textField.setText(textField.getText() + ".");
                        }
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new SwingCalculator();
    }
}
