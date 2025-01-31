import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[6]; // +, -, *, /, %, =
    private JButton addButton, subButton, mulButton, divButton, modButton, eqButton;
    private JButton clrButton, delButton;
    private JPanel panel;
    
    private double num1, num2, result;
    private char operator;

    public Calculator() {
        // Frame Properties
        setTitle("My calculator");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

 

        // Create text field
        textField = new JTextField();
        textField.setBounds(30, 25, 320, 50);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 22));
        add(textField);
        
        // Create function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        eqButton = new JButton("=");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = modButton;
        functionButtons[5] = eqButton;

        // Configure function buttons
        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.RED);
        }
        
        // Create number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].setBackground(Color.GRAY);
            numberButtons[i].setForeground(Color.WHITE);
        }
        
        // Create Clear and Delete buttons
        clrButton = new JButton("C");
        delButton = new JButton("DEL");
        clrButton.addActionListener(this);
        delButton.addActionListener(this);
        clrButton.setFont(new Font("Arial", Font.BOLD, 20));
        delButton.setFont(new Font("Arial", Font.BOLD, 20));
        clrButton.setBackground(Color.RED);
        delButton.setBackground(Color.ORANGE);
        clrButton.setForeground(Color.WHITE);
        delButton.setForeground(Color.BLACK);
        
        // Panel for buttons
        panel = new JPanel();
        panel.setBounds(30, 100, 320, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(Color.BLACK);

        // Add buttons to panel
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
        
        panel.add(clrButton);
        panel.add(numberButtons[0]);
        panel.add(modButton);
        panel.add(divButton);
        
        panel.add(delButton);
        panel.add(eqButton);
        
        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        } else if (e.getSource() == modButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        } else if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());

            try {
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/': 
                        if (num2 == 0) {
                            textField.setText("Error: Div by 0");
                            return;
                        }
                        result = num1 / num2; 
                        break;
                    case '%': 
                        if (num2 == 0) {
                            textField.setText("Error: Mod by 0");
                            return;
                        }
                        result = num1 % num2; 
                        break;
                    default: result = 0;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
            } catch (Exception ex) {
                textField.setText("Error");
            }
        } else if (e.getSource() == clrButton) {
            textField.setText("");
        } else if (e.getSource() == delButton) {
            String str = textField.getText();
            if (!str.equals("")) {
                textField.setText(str.substring(0, str.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
