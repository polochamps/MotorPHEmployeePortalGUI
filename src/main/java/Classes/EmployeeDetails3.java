

package Classes;


import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;


import com.opencsv.CSVWriter;

public class EmployeeDetails3 extends JFrame {
    
    private final String csvFilePath = "src/main/java/csv/MotorPH Employee Data.csv";

    public EmployeeDetails3() {
        setTitle("Add New Employee - powered by WorkMate™");
        setSize(800, 800);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Only closes the active window
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Employee Number Label and Text Field
        JLabel numberLabel = new JLabel("Employee Number:");
        JTextField numberTextField = new JTextField();

        // First Name Label and Text Field
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameTextField = new JTextField();

        // Last Name Label and Text Field
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameTextField = new JTextField();

        // Birthday Label and Text Field
        JLabel birthdayLabel = new JLabel("Birthday:");
        JTextField birthdayTextField = new JTextField();

        // Address Label and Text Field
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressTextField = new JTextField();

        // Phone Number Label and Text Field
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneTextField = new JTextField();

        // SSS Label and Text Field
        JLabel sssLabel = new JLabel("SSS:");
        JTextField sssTextField = new JTextField();

        // PhilHealth Label and Text Field
        JLabel philHealthLabel = new JLabel("PhilHealth:");
        JTextField philHealthTextField = new JTextField();

        // TIN Label and Text Field
        JLabel tinLabel = new JLabel("TIN:");
        JTextField tinTextField = new JTextField();

        // Pag-ibig Label and Text Field
        JLabel pagIbigLabel = new JLabel("Pag-IBIG:");
        JTextField pagIbigTextField = new JTextField();

        // Status Label and Text Field
        JLabel statusLabel = new JLabel("Status:");
        JTextField statusTextField = new JTextField();

        // Position Label and Text Field
        JLabel positionLabel = new JLabel("Position:");
        JTextField positionTextField = new JTextField();

        // Immediate Supervisor Label and Text Field
        JLabel supervisorLabel = new JLabel("Immediate Supervisor:");
        JTextField supervisorTextField = new JTextField();

        // Basic Salary Label and Text Field
        JLabel basicSalaryLabel = new JLabel("Basic Salary:");
        JTextField basicSalaryTextField = new JTextField();

        // Rice Subsidy Label and Text Field
        JLabel riceSubsidyLabel = new JLabel("Rice Subsidy:");
        JTextField riceSubsidyTextField = new JTextField();

        // Phone Allowance Label and Text Field
        JLabel phoneAllowanceLabel = new JLabel("Phone Allowance:");
        JTextField phoneAllowanceTextField = new JTextField();

        // Clothing Allowance Label and Text Field
        JLabel clothingAllowanceLabel = new JLabel("Clothing Allowance:");
        JTextField clothingAllowanceTextField = new JTextField();

        // Gross Semi-monthly Rate Label and Text Field
        JLabel grossSemiMonthlyRateLabel = new JLabel("Gross Semi-monthly Rate:");
        JTextField grossSemiMonthlyRateTextField = new JTextField();

        // Hourly Rate Label and Text Field
        JLabel hourlyRateLabel = new JLabel("Hourly Rate:");
        JTextField hourlyRateTextField = new JTextField();

        // Add components to the panel
        panel.add(numberLabel);
        panel.add(numberTextField);
        panel.add(firstNameLabel);
        panel.add(firstNameTextField);
        panel.add(lastNameLabel);
        panel.add(lastNameTextField);
        panel.add(birthdayLabel);
        panel.add(birthdayTextField);
        panel.add(addressLabel);
        panel.add(addressTextField);
        panel.add(phoneLabel);
        panel.add(phoneTextField);
        panel.add(sssLabel);
        panel.add(sssTextField);
        panel.add(philHealthLabel);
        panel.add(philHealthTextField);
        panel.add(tinLabel);
        panel.add(tinTextField);
        panel.add(pagIbigLabel);
        panel.add(pagIbigTextField);
        panel.add(statusLabel);
        panel.add(statusTextField);
        panel.add(positionLabel);
        panel.add(positionTextField);
        panel.add(supervisorLabel);
        panel.add(supervisorTextField);
        panel.add(basicSalaryLabel);
        panel.add(basicSalaryTextField);
        panel.add(riceSubsidyLabel);
        panel.add(riceSubsidyTextField);
        panel.add(phoneAllowanceLabel);
        panel.add(phoneAllowanceTextField);
        panel.add(clothingAllowanceLabel);
        panel.add(clothingAllowanceTextField);
        panel.add(grossSemiMonthlyRateLabel);
        panel.add(grossSemiMonthlyRateTextField);
        panel.add(hourlyRateLabel);
        panel.add(hourlyRateTextField);
        

        // Add Save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            String[] employeeDetails = new String[]{
                numberTextField.getText(),
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                birthdayTextField.getText(),
                addressTextField.getText(),
                phoneTextField.getText(),
                sssTextField.getText(),
                philHealthTextField.getText(),
                tinTextField.getText(),
                pagIbigTextField.getText(),
                statusTextField.getText(),
                positionTextField.getText(),
                supervisorTextField.getText(),
                basicSalaryTextField.getText(),
                riceSubsidyTextField.getText(),
                phoneAllowanceTextField.getText(),
                clothingAllowanceTextField.getText(),
                grossSemiMonthlyRateTextField.getText(),
                hourlyRateTextField.getText()
            };

            addEmployeeToCSV(employeeDetails);
        });

        panel.add(saveButton); // Add the Save button

        // Add panel to the frame
        add(panel);

        setVisible(true);
    }

    private void addEmployeeToCSV(String[] employeeDetails) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath, true))) {
            writer.writeNext(employeeDetails);
            JOptionPane.showMessageDialog(this, "New employee added successfully.", "Add Successful", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving employee details.", "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new EmployeeDetails3().setVisible(true));
    }
}
