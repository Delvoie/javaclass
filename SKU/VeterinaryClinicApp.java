/*
 * Lucas Delvoie
 * Date: December 13th, 2024
 * Description: Swing GUI to register new patients for a veterinary clinic. 
 */

 import javax.swing.*;
 import java.awt.*;
 import java.io.BufferedReader;
 import java.io.File;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Date;
 
 public class VeterinaryClinicApp {
  // Java Swing | Simple User Registration Form geeksforgeeks (2021) https://www.geeksforgeeks.org/java-swing-simple-user-registration-form

     public static void main(String[] args) {
         SwingUtilities.invokeLater(VeterinaryClinicApp::new);
     }
 
     public VeterinaryClinicApp() {
         // Create main frame
         JFrame frame = new JFrame("Register a New Patient");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(500, 400);
         frame.setLayout(new BorderLayout());
 
         // Create input panel to hold form elements
         JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
 
         // Patient name label and text field
         JLabel patientNameLabel = new JLabel("Patient Name:");
         JTextField patientNameText = new JTextField();
 
         // Owner name label and text field
         JLabel ownerNameLabel = new JLabel("Owner Name:");
         JTextField ownerNameText = new JTextField();
 
         // Email label and text field
         JLabel emailLabel = new JLabel("Email Address:");
         JTextField txtEmail = new JTextField();
 
         // Veterinarian selection label
         JLabel vetLabel = new JLabel("Select Veterinarian:");
 
         // Panel for veterinarian selection (horizontal alignment for flexibility)
         JPanel vetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
         JRadioButton rbVet1 = new JRadioButton("Dr. Lucas", true);
         JRadioButton rbVet2 = new JRadioButton("Dr. Delvoie");
         JRadioButton rbVet3 = new JRadioButton("Dr. Mario");
 
         // Group radio buttons to ensure only one selection at a time
         ButtonGroup vetGroup = new ButtonGroup();
         vetGroup.add(rbVet1);
         vetGroup.add(rbVet2);
         vetGroup.add(rbVet3);
 
         // Add radio buttons to vetPanel
         vetPanel.add(rbVet1);
         vetPanel.add(rbVet2);
         vetPanel.add(rbVet3);
 
         // Add all input components to inputPanel
         inputPanel.add(patientNameLabel);
         inputPanel.add(patientNameText);
         inputPanel.add(ownerNameLabel);
         inputPanel.add(ownerNameText);
         inputPanel.add(emailLabel);
         inputPanel.add(txtEmail);
         inputPanel.add(vetLabel);
         inputPanel.add(vetPanel);
 
         // Message label for displaying validation or success messages
         JLabel validateMessage = new JLabel("", JLabel.CENTER);
         validateMessage.setForeground(Color.RED);
 
         // Button panel for action buttons
         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
         JButton btnRegister = new JButton("Register");
         JButton btnClear = new JButton("Clear");
         JButton btnExit = new JButton("Exit");
         JButton btnImport = new JButton("Check Patient info");
 
         // Add buttons to buttonPanel
         buttonPanel.add(btnRegister);
         buttonPanel.add(btnClear);
         buttonPanel.add(btnExit);
         buttonPanel.add(btnImport);
 
         // Add action listener for Register button
         btnRegister.addActionListener(e -> {
             String patientName = patientNameText.getText().trim(); // Get patient name
             String ownerName = ownerNameText.getText().trim(); // Get owner name
             String email = txtEmail.getText().trim(); // Get email address
 
             // Determine which veterinarian is selected
             String vet = rbVet1.isSelected() ? rbVet1.getText() : 
                         rbVet2.isSelected() ? rbVet2.getText() : 
                         rbVet3.getText();
 
             Date currentDate = new Date(); // Get the current date
 
             // Validate inputs
             if (patientName.isEmpty()) {
                 validateMessage.setText("Error: Patient name cannot be empty.");
                 return;
             }
             if (ownerName.isEmpty()) {
                 validateMessage.setText("Error: Owner name cannot be empty.");
                 return;
             }
             if (email.isEmpty() || !isValidEmail(email)) {
                 validateMessage.setText("Error: Invalid email address.");
                 return;
             }
 
             // Open file chooser to save data
             // Java Swing | JFileChooser geeksforgeeks (2022) https://www.geeksforgeeks.org/java-swing-jfilechooser/
             JFileChooser fileChooser = new JFileChooser();
             if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                 try (FileWriter writer = new FileWriter(fileChooser.getSelectedFile())) {
                     // Write registration details to file
                     writer.write("**Patient Registration Document**\n");
                     writer.write("Patient Name: " + patientName + "\n");
                     writer.write("Owner Name: " + ownerName + "\n");
                     writer.write("Email Address: " + email + "\n");
                     writer.write("Assigned Vet: " + vet + "\n");
                     writer.write("Date: " + currentDate + "\n");
 
                     // Display success message
                     validateMessage.setText("Registration successful!");
                 } catch (IOException ex) {
                     validateMessage.setText("Error writing to file: " + ex.getMessage());
                 }
             }
         });
 
         // Add action listener for Clear button
         btnClear.addActionListener(e -> {
             patientNameText.setText(""); // Clear patient name field
             ownerNameText.setText(""); // Clear owner name field
             txtEmail.setText(""); // Clear email field
             rbVet1.setSelected(true); // Reset vet selection to default
             validateMessage.setText(""); // Clear message label
         });
 
         // Add action listener for Exit button
         btnExit.addActionListener(e -> System.exit(0)); // Exit the application
 
         // Add action listener for Import button
         // How do java Imports work (swing)? (2015) https://stackoverflow.com/questions/31144154/how-do-java-imports-work-swing
         btnImport.addActionListener(e -> {
             JFileChooser fileChooser = new JFileChooser();
             if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                 File file = fileChooser.getSelectedFile();
                 try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                     String line;
                     while ((line = reader.readLine()) != null) {
                         if (line.startsWith("Patient Name: ")) {
                             patientNameText.setText(line.replace("Patient Name: ", ""));
                         } else if (line.startsWith("Owner Name: ")) {
                             ownerNameText.setText(line.replace("Owner Name: ", ""));
                         } else if (line.startsWith("Email Address: ")) {
                             txtEmail.setText(line.replace("Email Address: ", ""));
                         } else if (line.startsWith("Assigned Vet: ")) {
                             String vet = line.replace("Assigned Vet: ", "");
                             if (vet.equals(rbVet1.getText())) {
                                 rbVet1.setSelected(true);
                             } else if (vet.equals(rbVet2.getText())) {
                                 rbVet2.setSelected(true);
                             } else if (vet.equals(rbVet3.getText())) {
                                 rbVet3.setSelected(true);
                             }
                         }
                     }
                     validateMessage.setText("Data imported successfully.");
                 } catch (IOException ex) {
                     validateMessage.setText("Error reading file: " + ex.getMessage());
                 }
             }
         });
 
         // Add panels to frame
         frame.add(inputPanel, BorderLayout.CENTER); // Add input panel to center
         frame.add(validateMessage, BorderLayout.NORTH); // Add message label to top
         frame.add(buttonPanel, BorderLayout.SOUTH); // Add button panel to bottom
 
         frame.setVisible(true); // Make the frame visible
     }
 
     // Helper method to validate email using regex
     // Stack Overflow 2024 https://stackoverflow.com/questions/8204680/java-regex-email
     private static boolean isValidEmail(String email) {
         return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
     }
 }
