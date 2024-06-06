

package Classes;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import Classes.Taxes;


public class EmployeeDetails2 extends JFrame {

    private final String employeeNumber;
    private final String firstName;
    private final String lastName;

    private final String[] employeeDetails;
    private final String csvFilePath = "src/main/java/csv/MotorPH Employee Data.csv";

    public EmployeeDetails2(String employeeNumber, String firstName, String lastName, String birthday, String address, String phoneNumber, String sss, String philHealth, String tin, String pagIbig, String status, String position, String supervisor, String basicSalary, String riceSubsidy, String phoneAllowance, String clothingAllowance, String grossSemiMonthlyRate, String hourlyRate) {
       
        
        
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

        // Add Labels and Text Fields for Employee Details
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameTextField = new JTextField(lastName);
        lastNameTextField.setEditable(false);

        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameTextField = new JTextField(firstName);
        firstNameTextField.setEditable(false);

        JLabel numberLabel = new JLabel("Employee Number:");
        JTextField numberTextField = new JTextField(employeeNumber);
        numberTextField.setEditable(false);

        JLabel birthdayLabel = new JLabel("Birthday:");
        JTextField birthdayTextField = new JTextField(birthday);
        birthdayTextField.setEditable(false);

        JLabel addressLabel = new JLabel("Address:");
        JTextField addressTextField = new JTextField(address);
        addressTextField.setEditable(false);

        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneTextField = new JTextField(phoneNumber);
        phoneTextField.setEditable(false);

        JLabel sssLabel = new JLabel("SSS:");
        JTextField sssTextField = new JTextField(sss);
        sssTextField.setEditable(false);

        JLabel philHealthLabel = new JLabel("PhilHealth:");
        JTextField philHealthTextField = new JTextField(philHealth);
        philHealthTextField.setEditable(false);

        JLabel tinLabel = new JLabel("TIN:");
        JTextField tinTextField = new JTextField(tin);
        tinTextField.setEditable(false);

        JLabel pagIbigLabel = new JLabel("Pag-IBIG:");
        JTextField pagIbigTextField = new JTextField(pagIbig);
        pagIbigTextField.setEditable(false);

        JLabel statusLabel = new JLabel("Status:");
        JTextField statusTextField = new JTextField(status);
        statusTextField.setEditable(false);

        JLabel positionLabel = new JLabel("Position:");
        JTextField positionTextField = new JTextField(position);
        positionTextField.setEditable(false);

        JLabel supervisorLabel = new JLabel("Immediate Supervisor:");
        JTextField supervisorTextField = new JTextField(supervisor);
        supervisorTextField.setEditable(false);

        JLabel basicSalaryLabel = new JLabel("Basic Salary:");
        JTextField basicSalaryTextField = new JTextField(basicSalary);
        basicSalaryTextField.setEditable(false);

        JLabel riceSubsidyLabel = new JLabel("Rice Subsidy:");
        JTextField riceSubsidyTextField = new JTextField(riceSubsidy);
        riceSubsidyTextField.setEditable(false);

        JLabel phoneAllowanceLabel = new JLabel("Phone Allowance:");
        JTextField phoneAllowanceTextField = new JTextField(phoneAllowance);
        phoneAllowanceTextField.setEditable(false);

        JLabel clothingAllowanceLabel = new JLabel("Clothing Allowance:");
        JTextField clothingAllowanceTextField = new JTextField(clothingAllowance);
        clothingAllowanceTextField.setEditable(false);

        JLabel grossSemiMonthlyRateLabel = new JLabel("Gross Semi-monthly Rate:");
        JTextField grossSemiMonthlyRateTextField = new JTextField(grossSemiMonthlyRate);
        grossSemiMonthlyRateTextField.setEditable(false);

        JLabel hourlyRateLabel = new JLabel("Hourly Rate:");
        JTextField hourlyRateTextField = new JTextField(hourlyRate);
        hourlyRateTextField.setEditable(false);

        // Add components to the panel
        panel.add(firstNameLabel);
        panel.add(firstNameTextField);
        panel.add(lastNameLabel);
        panel.add(lastNameTextField);
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


        // Add Net Salary Label and Text Field
        JLabel netSalaryLabel = new JLabel("Net Salary:");
        JTextField netSalaryTextField = new JTextField();
        netSalaryTextField.setEditable(false);
        panel.add(netSalaryLabel);
        panel.add(netSalaryTextField);
        
         // Add Leave Request button
        JButton leaveRequestButton = new JButton("Leave Request");
        leaveRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                               
                // Create and display LeaveRequest window
                new LeaveRequest().setVisible(true);
            }
        });
        
        panel.add(leaveRequestButton); // Add the Leave Request button

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

                    // Format and display the net salary
                    netSalaryTextField.setText(String.format("PHP %.2f", netSalary));

                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error parsing salary values. Please check the input.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(computeButton); // Add the Compute button

        add(panel);
        
        setVisible(true);
        
    }

    private double parseBasicSalary(String basicSalaryStr) throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        Number number = format.parse(basicSalaryStr);
        return number.doubleValue();
    }

    private double computeNetSalary(double basicSalary, double sssDeduction, double philHealthDeduction, double pagibigDeduction, double withholdingTaxDeduction) {
        return basicSalary - sssDeduction - philHealthDeduction - pagibigDeduction - withholdingTaxDeduction;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Example data for testing
            new EmployeeDetails2("001", "John", "Doe", "1990-01-01", "123 Main St", "09123456789", "SSS123", "PH123", "TIN123", "PG123", "Single", "Engineer", "Jane Smith", "30000", "2000", "1000", "1500", "15000", "200").setVisible(true);
        });
    }
}

