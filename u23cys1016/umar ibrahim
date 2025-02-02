// Importing necessary libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener { // Main class implementing ActionListener interface

    JFrame frame; // JFrame for the main window
    JTextField textfield; // JTextField to display inputs and results
    JButton[] numberButtons = new JButton[10]; // Array of number buttons (0 to 9)
    JButton[] functionButtons = new JButton[9]; // Array for function buttons (e.g., add, subtract, etc.)
    
    // Declaring individual function buttons
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;

    JPanel panel; // Panel to hold the number buttons

    Font myFont = new Font("Ink Free", Font.BOLD, 30); // Font style for buttons and textfield

    // Variables for storing the two numbers, result, and operator
    double num1 = 0, num2 = 0, result = 0;
    char operator; // Variable to store the current operator (+, -, *, /)

    // Constructor to set up the calculator GUI
    Calculator() {

        // Create JFrame and set its properties
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the program when the window is closed
        frame.setSize(420, 550); // Set the window size
        frame.setLayout(null); // Set layout manager to null (absolute positioning)

        // Set up the text field to display the current input/result
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50); // Set position and size of the text field
        textfield.setFont(myFont); // Set the font of the text field
        textfield.setEditable(false); // Make the text field non-editable

        // Initialize function buttons (e.g., +, -, *, /, etc.)
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        // Assign each function button to the functionButtons array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Set up event listeners for each function button
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this); // Add action listener for each button
            functionButtons[i].setFont(myFont); // Set font style
            functionButtons[i].setFocusable(false); // Disable focus on buttons
        }

        // Initialize number buttons (0 to 9) and set their properties
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); // Create a button for each number
            numberButtons[i].addActionListener(this); // Add action listener
            numberButtons[i].setFont(myFont); // Set font style
            numberButtons[i].setFocusable(false); // Disable focus on buttons
        }

        // Set positions and sizes for the extra function buttons
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // Create a panel for the number buttons and set its layout
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300); // Position and size of the panel
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid layout for number buttons

        // Add number and operator buttons to the panel
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
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add all components to the frame
        frame.add(panel); // Add the number buttons panel
        frame.add(negButton); // Add the negative button
        frame.add(delButton); // Add the delete button
        frame.add(clrButton); // Add the clear button
        frame.add(textfield); // Add the text field

        // Make the frame visible
        frame.setVisible(true);
    }

    // Main method to create an instance of Calculator
    public static void main(String[] args) {
        Calculator calc = new Calculator(); // Create a new Calculator object
    }

    // Override the actionPerformed method to define the actions for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {

        // Handle number button clicks (0 to 9)
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i))); // Add the clicked number to the text field
            }
        }

        // Handle decimal point button click
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat(".")); // Add a decimal point to the text field
        }

        // Handle operator button clicks (+, -, *, /)
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText()); // Store the first number
            operator = '+'; // Set the operator to addition
            textfield.setText(""); // Clear the text field for the second number
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText()); // Store the first number
            operator = '-'; // Set the operator to subtraction
            textfield.setText(""); // Clear the text field for the second number
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText()); // Store the first number
            operator = '*'; // Set the operator to multiplication
            textfield.setText(""); // Clear the text field for the second number
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText()); // Store the first number
            operator = '/'; // Set the operator to division
            textfield.setText(""); // Clear the text field for the second number
        }

        // Handle equal button click to perform the calculation
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText()); // Store the second number

            // Perform the operation based on the selected operator
            switch (operator) {
                case '+':
                    result = num1 + num2; // Addition
                    break;
                case '-':
                    result = num1 - num2; // Subtraction
                    break;
                case '*':
                    result = num1 * num2; // Multiplication
                    break;
                case '/':
                    result = num1 / num2; // Division
                    break;
            }

            textfield.setText(String.valueOf(result)); // Display the result
            num1 = result; // Store the result for further calculations
        }

        // Handle clear button click to clear the text field
        if (e.getSource() == clrButton) {
            textfield.setText(""); // Clear the text field
        }

        // Handle delete button click to delete the last character in the text field
        if (e.getSource() == delButton) {
            String string = textfield.getText(); // Get the current text in the text field
            textfield.setText(""); // Clear the text field
            // Loop through the string and append all characters except the last one
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }

        // Handle negative button click to negate the current number
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText()); // Get the current number
            temp *= -1; // Negate the number
            textfield.setText(String.valueOf(temp)); // Display the negated number
        }
    }
}
