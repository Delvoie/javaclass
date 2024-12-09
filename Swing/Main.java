package Swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private static String savedText = "";
    
    // GeeksForGeeks (2021) Java AWT | BorderLayout Class (2021) https://www.geeksforgeeks.org/java-awt-borderlayout-class/
    public static void main(String[] args) {
        // Create frame and title
        JFrame frame = new JFrame("Text Editor");
        frame.setSize(300, 200);
        //exit frame on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //utalize borderlayout
        frame.setLayout(new BorderLayout());

        // Create text area
        JTextArea textArea = new JTextArea("");
        textArea.setToolTipText("Insert Your Text Here:");
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create status bar
        JLabel textLabel = new JLabel("Enter Text Here");
        frame.add(textLabel, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        JButton SaveButton = new JButton("Save");
        buttonPanel.add(SaveButton);
        JButton openButton = new JButton("Open");
        buttonPanel.add(openButton);
        JButton exitButton = new JButton("Exit");
        buttonPanel.add(exitButton);
        
        frame.add(buttonPanel, BorderLayout.SOUTH);

// Add event listeners
        // button to Save button
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                if (text.equals("password")) {
                    System.out.println("Login successful!");

                // Show a message dialog
                    JOptionPane.showMessageDialog(frame, "My dog ate my coding assignment \n ... \n" +
                        "It took him a couple bytes");
                } else {
                    savedText = text;
                    System.out.println(String.format("Text Saved %s", textArea.getText()));
                    textLabel.setText("Text saved successfully");
                }
            }
        });
        // button to open text
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                textArea.setText(savedText);
                System.out.println(String.format("Text loaded: %s", textArea.getText()));
                textLabel.setText("Text loaded successfully");
            }
        });
        // button to exit
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}