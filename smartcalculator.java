import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmartCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] digitButtons = new JButton[10];
    private JButton[] operatorButtons = new JButton[6]; // +, -, *, /, %, =
    private JButton plusBtn, minusBtn, multiplyBtn, divideBtn, modBtn, equalsBtn;
    private JButton clearBtn, backspaceBtn;
    private JPanel buttonPanel;
    
    private double firstNum, secondNum, calcResult;
    private char selectedOperator;

    public CustomCalculator() {
        // Frame Properties
        setTitle("Smart Calculator");
        setSize(420, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.DARK_GRAY);

        // Create display field
        display = new JTextField();
        display.setBounds(30, 25, 350, 50);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 22));
        add(display);
        
        // Define operator buttons
        plusBtn = new JButton("+");
        minusBtn = new JButton("-");
        multiplyBtn = new JButton("*");
        divideBtn = new JButton("/");
        modBtn = new JButton("%");
        equalsBtn = new JButton("=");

        operatorButtons[0] = plusBtn;
        operatorButtons[1] = minusBtn;
        operatorButtons[2] = multiplyBtn;
        operatorButtons[3] = divideBtn;
        operatorButtons[4] = modBtn;
        operatorButtons[5] = equalsBtn;

        // Configure operator buttons
        for (JButton btn : operatorButtons) {
            btn.addActionListener(this);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setBackground(Color.LIGHT_GRAY);
            btn.setForeground(Color.BLACK);
        }
        
        // Create digit buttons
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            digitButtons[i].addActionListener(this);
            digitButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            digitButtons[i].setBackground(Color.GRAY);
            digitButtons[i].setForeground(Color.WHITE);
        }
        
        // Create clear and backspace buttons
        clearBtn = new JButton("AC");
        backspaceBtn = new JButton("←");
        clearBtn.addActionListener(this);
        backspaceBtn.addActionListener(this);
        clearBtn.setFont(new Font("Arial", Font.BOLD, 20));
        backspaceBtn.setFont(new Font("Arial", Font.BOLD, 20));
        clearBtn.setBackground(Color.RED);
        backspaceBtn.setBackground(Color.ORANGE);
        clearBtn.setForeground(Color.WHITE);
        backspaceBtn.setForeground(Color.BLACK);
        
        // Panel for buttons
        buttonPanel = new JPanel();
        buttonPanel.setBounds(30, 100, 350, 400);
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(Color.DARK_GRAY);

        // Add buttons to panel
        buttonPanel.add(digitButtons[7]);
        buttonPanel.add(digitButtons[8]);
        buttonPanel.add(digitButtons[9]);
        buttonPanel.add(divideBtn);
        
        buttonPanel.add(digitButtons[4]);
        buttonPanel.add(digitButtons[5]);
        buttonPanel.add(digitButtons[6]);
        buttonPanel.add(multiplyBtn);
        
        buttonPanel.add(digitButtons[1]);
        buttonPanel.add(digitButtons[2]);
        buttonPanel.add(digitButtons[3]);
        buttonPanel.add(minusBtn);
        
        buttonPanel.add(digitButtons[0]);
        buttonPanel.add(clearBtn);
        buttonPanel.add(modBtn);
        buttonPanel.add(plusBtn);
        
        buttonPanel.add(backspaceBtn);
        buttonPanel.add(equalsBtn);
        
        add(buttonPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == digitButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        
        if (e.getSource() == plusBtn) {
            firstNum = Double.parseDouble(display.getText());
            selectedOperator = '+';
            display.setText("");
        } else if (e.getSource() == minusBtn) {
            firstNum = Double.parseDouble(display.getText());
            selectedOperator = '-';
            display.setText("");
        } else if (e.getSource() == multiplyBtn) {
            firstNum = Double.parseDouble(display.getText());
            selectedOperator = '*';
            display.setText("");
        } else if (e.getSource() == divideBtn) {
            firstNum = Double.parseDouble(display.getText());
            selectedOperator = '/';
            display.setText("");
        } else if (e.getSource() == modBtn) {
            firstNum = Double.parseDouble(display.getText());
            selectedOperator = '%';
            display.setText("");
        } else if (e.getSource() == equalsBtn) {
            secondNum = Double.parseDouble(display.getText());

            try {
                switch (selectedOperator) {
                    case '+': calcResult = firstNum + secondNum; break;
                    case '-': calcResult = firstNum - secondNum; break;
                    case '*': calcResult = firstNum * secondNum; break;
                    case '/': 
                        if (secondNum == 0) {
                            display.setText("Error: Div by 0");
                            return;
                        }
                        calcResult = firstNum / secondNum; 
                        break;
                    case '%': 
                        if (secondNum == 0) {
                            display.setText("Error: Mod by 0");
                            return;
                        }
                        calcResult = firstNum % secondNum; 
                        break;
                    default: calcResult = 0;
                }
                display.setText(String.valueOf(calcResult));
                firstNum = calcResult;
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else if (e.getSource() == clearBtn) {
            display.setText("");
        } else if (e.getSource() == backspaceBtn) {
            String str = display.getText();
            if (!str.isEmpty()) {
                display.setText(str.substring(0, str.length() - 1));
            }
        }
    }

    public static void main(String[] args) {
        new SmartCalculator();
    }
}
