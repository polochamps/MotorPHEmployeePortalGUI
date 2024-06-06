

package Classes;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import Classes.Taxes;

public class EmployeeDetails extends javax.swing.JFrame {

    private String employeeNumber;
    private String firstName;
    private String lastName;

    private String[] employeeDetails;
    private String csvFilePath = "src/main/java/csv/MotorPH Employee Data.csv";

    public EmployeeDetails(String employeeNumber, String firstName, String lastName, String birthday, String address, String phoneNumber, String sss, String philHealth, String tin, String pagIbig, String status, String position, String supervisor, String basicSalary, String riceSubsidy, String phoneAllowance, String clothingAllowance, String grossSemiMonthlyRate, String hourlyRate) {

        // Initialize instance variables
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;

        employeeDetails = new String[]{employeeNumber, firstName, lastName, birthday, address, phoneNumber, sss, philHealth, tin, pagIbig, status, position, supervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate};

        setTitle("Employee Details - powered by WorkMate™");
        setSize(800, 800);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Only closes the active window
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the window on close
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); // 2 columns, 10px horizontal and vertical gap

        // Add padding to the panel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Last Name Label and Text Field
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameTextField = new JTextField(lastName);

        // First Name Label and Text Field
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameTextField = new JTextField(firstName);

        // Employee Number Label and Text Field
        JLabel numberLabel = new JLabel("Employee Number:");
        JTextField numberTextField = new JTextField(employeeNumber);
        numberTextField.setEditable(false);

        // Birthday Label and Text Field
        JLabel birthdayLabel = new JLabel("Birthday:");
        JTextField birthdayTextField = new JTextField(birthday);

        // Address Label and Text Field
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressTextField = new JTextField(address);

        // Phone Number Label and Text Field
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneTextField = new JTextField(phoneNumber);

        // SSS Label and Text Field
        JLabel sssLabel = new JLabel("SSS:");
        JTextField sssTextField = new JTextField(sss);

        // PhilHealth Label and Text Field
        JLabel philHealthLabel = new JLabel("PhilHealth:");
        JTextField philHealthTextField = new JTextField(philHealth);

        // TIN Label and Text Field
        JLabel tinLabel = new JLabel("TIN:");
        JTextField tinTextField = new JTextField(tin);

        // Pag-ibig Label and Text Field
        JLabel pagIbigLabel = new JLabel("Pag-IBIG:");
        JTextField pagIbigTextField = new JTextField(pagIbig);

        // Status Label and Text Field
        JLabel statusLabel = new JLabel("Status:");
        JTextField statusTextField = new JTextField(status);

        // Position Label and Text Field
        JLabel positionLabel = new JLabel("Position:");
        JTextField positionTextField = new JTextField(position);

        // Immediate Supervisor Label and Text Field
        JLabel supervisorLabel = new JLabel("Immediate Supervisor:");
        JTextField supervisorTextField = new JTextField(supervisor);

        // Basic Salary Label and Text Field
        JLabel basicSalaryLabel = new JLabel("Basic Salary:");
        JTextField basicSalaryTextField = new JTextField(basicSalary);

        // Rice Subsidy Label and Text Field
        JLabel riceSubsidyLabel = new JLabel("Rice Subsidy:");
        JTextField riceSubsidyTextField = new JTextField(riceSubsidy);

        // Phone Allowance Label and Text Field
        JLabel phoneAllowanceLabel = new JLabel("Phone Allowance:");
        JTextField phoneAllowanceTextField = new JTextField(phoneAllowance);

        // Clothing Allowance Label and Text Field
        JLabel clothingAllowanceLabel = new JLabel("Clothing Allowance:");
        JTextField clothingAllowanceTextField = new JTextField(clothingAllowance);

        // Gross Semi-monthly Rate Label and Text Field
        JLabel grossSemiMonthlyRateLabel = new JLabel("Gross Semi-monthly Rate:");
        JTextField grossSemiMonthlyRateTextField = new JTextField(grossSemiMonthlyRate);

        // Hourly Rate Label and Text Field
        JLabel hourlyRateLabel = new JLabel("Hourly Rate:");
        JTextField hourlyRateTextField = new JTextField(hourlyRate);
        

        // Add components to the panel
        
        panel.add(firstNameLabel);
        panel.add(lastNameTextField);
        panel.add(lastNameLabel);
        panel.add(firstNameTextField);
        panel.add(numberLabel);
        panel.add(numberTextField);
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

        // Add JComboBox for month selection
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        panel.add(new JLabel("Select Month: "));
        panel.add(monthComboBox);

        // Add Net Salary Label and Text Field
        JLabel netSalaryLabel = new JLabel("Net Salary:");
        JTextField netSalaryTextField = new JTextField();
        netSalaryTextField.setEditable(false);
        panel.add(netSalaryLabel);
        panel.add(netSalaryTextField);

        // Add Save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            employeeDetails[1] = firstNameTextField.getText(); // Correctly set first name
            employeeDetails[2] = lastNameTextField.getText();  // Correctly set last name
            employeeDetails[3] = birthdayTextField.getText();
            employeeDetails[4] = addressTextField.getText();
            employeeDetails[5] = phoneTextField.getText();
            employeeDetails[6] = sssTextField.getText();
            employeeDetails[7] = philHealthTextField.getText();
            employeeDetails[8] = tinTextField.getText();
            employeeDetails[9] = pagIbigTextField.getText();
            employeeDetails[10] = statusTextField.getText();
            employeeDetails[11] = positionTextField.getText();
            employeeDetails[12] = supervisorTextField.getText();
            employeeDetails[13] = basicSalaryTextField.getText();
            employeeDetails[14] = riceSubsidyTextField.getText();
            employeeDetails[15] = phoneAllowanceTextField.getText();
            employeeDetails[16] = clothingAllowanceTextField.getText();
            employeeDetails[17] = grossSemiMonthlyRateTextField.getText();
            employeeDetails[18] = hourlyRateTextField.getText();

            updateCSVFile(employeeDetails);
        });

        panel.add(saveButton); // Add the Save button

        // Add Compute button
        JButton computeButton = new JButton("Compute");
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    // Parse the gross salary from the text field
                    double basicSalary = parseBasicSalary(basicSalaryTextField.getText());

                    // Compute other deductions
                    double sssDeduction = Taxes.calculateSssDeduction(basicSalary);
                    double philHealthDeduction = Taxes.calculatePhilhealthDeduction(basicSalary);
                    double pagibigDeduction = Taxes.calculatePagibigDeduction(basicSalary);
                    double withholdingTaxDeduction = Taxes.calculateWithholdingTax(basicSalary, sssDeduction, philHealthDeduction, pagibigDeduction);

                    // Compute net salary
                    double netSalary = computeNetSalary(basicSalary, sssDeduction, philHealthDeduction, pagibigDeduction, withholdingTaxDeduction);

                    // Display net salary in the text field
                    netSalaryTextField.setText(NumberFormat.getCurrencyInstance().format(netSalary));
                    
                } catch (NumberFormatException ex) {
                    
                    // Handle parsing errors
                    JOptionPane.showMessageDialog(null, "Error: Invalid input format for salary. Please enter a valid number.");
                    ex.printStackTrace(); // Print stack trace for debugging
                    
                } catch (ParseException ex) {
                    
                    // Handle parsing errors for gross semi-monthly rate text field
                    JOptionPane.showMessageDialog(null, "Error: Invalid input format for gross semi-monthly rate. Please enter a valid number.");
                    ex.printStackTrace(); // Print stack trace for debugging
                }
            }
        });

        panel.add(computeButton); // Add the Compute button

        // Add panel to the frame
        add(panel);

        setVisible(true);
    }

    

    private void updateCSVFile(String[] updatedEmployeeDetails) {
        List<String[]> allEmployees = new ArrayList<>();
        boolean updated = false;

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equals(updatedEmployeeDetails[0])) {
                    allEmployees.add(updatedEmployeeDetails);
                    updated = true;
                } else {
                    allEmployees.add(line);
                }
            }
        } catch (IOException | com.opencsv.exceptions.CsvValidationException e) {
            e.printStackTrace();
        }

        if (updated) {
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                writer.writeAll(allEmployees);
                JOptionPane.showMessageDialog(this, "Employee details updated successfully.", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving employee details.", "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Employee not found in CSV file.", "Update Failed", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Method to compute net salary
    private double computeNetSalary(double grossSalary, double sssDeduction, double philHealthDeduction, double pagibigDeduction, double withholdingTaxDeduction) {
        return grossSalary - (sssDeduction + philHealthDeduction + pagibigDeduction + withholdingTaxDeduction);
    }

    // Method to parse gross salary
    private double parseBasicSalary(String input) throws ParseException {
        input = input.replaceAll(",", "");
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        Number number = format.parse(input);
        return number.doubleValue();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new EmployeeDetails("12345", "John", "Doe", "1990-01-01", "123 Main St", "123-456-7890", "123-456-789", "987-654-321", "456-789-012", "321-654-987", "Active", "Position", "Supervisor", "50000", "2000", "1500", "1000", "25000", "250").setVisible(true));
    }
}
