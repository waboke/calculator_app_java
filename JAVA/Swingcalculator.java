import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swingcalculator extends JFrame implements ActionListener {
    // Declare components
    private JTextField input1, input2, result;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, percentButton, submitButton;

    public Swingcalculator() {
        // Set up the frame
        setTitle("Swing Application Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 4));

        // Initialize components
        input1 = new JTextField();
        input2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        percentButton = new JButton("%");
        submitButton = new JButton("Submit");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        percentButton.addActionListener(this);
        submitButton.addActionListener(this);

        // Add components to the frame
        add(new JLabel("Input 1:"));
        add(input1);
        add(new JLabel("Input 2:"));
        add(input2);
        add(new JLabel("Ans:"));
        add(result);

        for (int i = 1; i <= 9; i++) {
            add(numberButtons[i]);
        }

        add(numberButtons[0]);
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);
        add(percentButton);
        add(submitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double res = 0;

            if (e.getSource() == addButton) {
                res = num1 + num2;
            } else if (e.getSource() == subButton) {
                res = num1 - num2;
            } else if (e.getSource() == mulButton) {
                res = num1 * num2;
            } else if (e.getSource() == divButton) {
                res = num1 / num2;
            } else if (e.getSource() == percentButton) {
                res = num1 % num2;
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Swingcalculator();
    }
}
