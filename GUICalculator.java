import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Cal extends JFrame implements ActionListener {
    // Create JFrame and JTextField
    static JFrame f;
    static JTextField l;
    
    // Store operands and operator
    String s0, s1, s2;

    // Constructor
    Cal() {
        s0 = s1 = s2 = "";
    }

    public static void main(String args[]) {
        f = new JFrame("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 400);
        f.setLayout(new BorderLayout());

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Cal c = new Cal();

        // Text field
        l = new JTextField();
        l.setEditable(false);
        l.setHorizontalAlignment(JTextField.RIGHT);
        l.setFont(new Font("Arial", Font.BOLD, 22));
        f.add(l, BorderLayout.NORTH);

        // Panel with grid layout
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 4, 5, 5));

        // Buttons
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        JButton[] buttons = new JButton[16];

        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
            buttons[i].addActionListener(c);
            p.add(buttons[i]);
        }

        // Clear button
        JButton clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.BOLD, 20));
        clearButton.addActionListener(c);
        f.add(clearButton, BorderLayout.SOUTH);

        f.add(p, BorderLayout.CENTER);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals(""))
                s2 += s;
            else
                s0 += s;
            l.setText(s0 + s1 + s2);
        } else if (s.equals("C")) {
            s0 = s1 = s2 = "";
            l.setText("");
        } else if (s.equals("=")) {
            if (!s0.isEmpty() && !s1.isEmpty() && !s2.isEmpty()) {
                double result;
                switch (s1) {
                    case "+": result = Double.parseDouble(s0) + Double.parseDouble(s2); break;
                    case "-": result = Double.parseDouble(s0) - Double.parseDouble(s2); break;
                    case "*": result = Double.parseDouble(s0) * Double.parseDouble(s2); break;
                    case "/": 
                        if (s2.equals("0")) {
                            l.setText("Error: Divide by 0");
                            return;
                        }
                        result = Double.parseDouble(s0) / Double.parseDouble(s2); 
                        break;
                    default: return;
                }
                s0 = String.valueOf(result);
                s1 = s2 = "";
                l.setText(s0);
            }
        } else {
            if (!s0.isEmpty() && s2.isEmpty()) {
                s1 = s;
                l.setText(s0 + s1);
            }
        }
    }
}
