import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dominioncalculator implements ActionListener {

    JFrame f;
    JTextField l;
    String s0, s1, s2;

    Calculator() {
        s0 = s1 = s2 = "";
    }

    public static void main(String args[]) {
        Calculator c = new Calculator();
        c.createGUI();
    }

    void createGUI() {
        f = new JFrame("Calculator");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        l = new JTextField(16);
        l.setEditable(false);

        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton beq1 = new JButton("=");
        JButton ba = new JButton("+");
        JButton bs = new JButton("-");
        JButton bd = new JButton("/");
        JButton bm = new JButton("*");
        JButton beq = new JButton("C");
        JButton be = new JButton(".");

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 4));
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b0);
        p.add(be);
        p.add(beq);
        p.add(ba);

        JPanel p2 = new JPanel();
        p2.add(l);
        p2.add(beq1);

        f.add(p2, BorderLayout.NORTH);
        f.add(p, BorderLayout.CENTER);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        be.addActionListener(this);
        beq.addActionListener(this);
        beq1.addActionListener(this);
        ba.addActionListener(this);
        bs.addActionListener(this);
        bd.addActionListener(this);
        bm.addActionListener(this);

        f.setSize(200, 220);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals("")) {
                s2 = s2 + s;
            } else {
                s0 = s0 + s;
            }
            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";
            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {
            double te;
            if (s1.equals("+")) {
                te = Double.parseDouble(s0) + Double.parseDouble(s2);
            } else if (s1.equals("-")) {
                te = Double.parseDouble(s0) - Double.parseDouble(s2);
            } else if (s1.equals("/")) {
                te = Double.parseDouble(s0) / Double.parseDouble(s2);
            } else {
                te = Double.parseDouble(s0) * Double.parseDouble(s2);
            }
            l.setText(s0 + s1 + s2 + "=" + te);
            s0 = Double.toString(te);
            s1 = s2 = "";
        } else {
            if (s1.equals("") || s2.equals("")) {
                s1 = s;
            } else {
                double te;
                if (s1.equals("+")) {
                    te = Double.parseDouble(s0) + Double.parseDouble(s2);
                } else if (s1.equals("-")) {
                    te = Double.parseDouble(s0) - Double.parseDouble(s2);
                } else if (s1.equals("/")) {
                    te = Double.parseDouble(s0) / Double.parseDouble(s2);
                } else {
                    te = Double.parseDouble(s0) * Double.parseDouble(s2);
                }
                s0 = Double.toString(te);
                s1 = s;
                s2 = "";
            }
            l.setText(s0 + s1 + s2);
        }
    }
}
