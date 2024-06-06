

package Classes;


import com.opencsv.CSVWriter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeaveRequest extends JFrame implements ActionListener {

    private JLabel nameLabel, startDateLabel, endDateLabel;
    private JTextField nameField, startDateField, endDateField;
    private JButton submitButton;

    private final String csvFilePath = "src/main/java/csv/Leave Requests Table.csv";

    public LeaveRequest() {
        setTitle("Leave Request Form - powered by WorkMate™");
        setSize(400, 200);     
        setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Only closes the active window
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Employee Name:");
        startDateLabel = new JLabel("Start Date:");
        endDateLabel = new JLabel("End Date:");

        nameField = new JTextField();
        startDateField = new JTextField();
        endDateField = new JTextField();

        // Set the preferred size for text fields (shorter height)
        Dimension textFieldSize = new Dimension(200, 24);
        nameField.setPreferredSize(textFieldSize);
        startDateField.setPreferredSize(textFieldSize);
        endDateField.setPreferredSize(textFieldSize);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(startDateLabel, gbc);

        gbc.gridx = 1;
        add(startDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(endDateLabel, gbc);

        gbc.gridx = 1;
        add(endDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitButton, gbc);

        // Center the window when it opens
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String startDate = startDateField.getText();
            String endDate = endDateField.getText();

            // Validate if any field is empty
            if (name.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }
            
            // Convert date format to dd/mm/yyyy
            String formattedStartDate = formatDate(startDate);
            String formattedEndDate = formatDate(endDate);

            // Check if date conversion was successful
            if (formattedStartDate == null || formattedEndDate == null) {
                JOptionPane.showMessageDialog(this, "Please enter the dates in a valid format (mm-dd-yyyy).");
                return;
            }

            // Append data to CSV file
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath, true))) {
                // Check if the last character is a newline, if not, write a newline
                if (writer.checkError()) {
                    writer.writeNext(new String[]{});
                }
                String[] record = {name, "Leave Type", startDate, endDate, "Pending"}; // Default status is Pending
                writer.writeNext(record);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // Show confirmation message
            JOptionPane.showMessageDialog(this, "Leave request submitted for " + name + " from " + startDate + " to " + endDate);

            // Clear text fields after submission
            nameField.setText("");
            startDateField.setText("");
            endDateField.setText("");
        }
    }
    
    private String formatDate(String date) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MM-dd-yyyy"); // Assuming the input format is dd-MM-yyyy
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date parsedDate = inputFormat.parse(date);
            return outputFormat.format(parsedDate);
        } catch (ParseException e) {
            return null; // Return null if the date is invalid
        }
    }

    public static void main(String[] args) {
        new LeaveRequest();
    }
}
