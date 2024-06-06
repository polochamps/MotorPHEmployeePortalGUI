

package Classes;


import Classes.EmployeeDetails;
import Classes.EmployeeDetails3; 
import Frames.LogInTest;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTable extends JFrame {

    private final String csvFilePath = "src/main/java/csv/MotorPH Employee Data.csv";

    public EmployeeTable(String employeeID) {
        setTitle("Employee Table - powered by WorkMate™");
        setSize(800, 625);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Only closes the active window
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        List<String[]> employeeData = readEmployeeData(csvFilePath, employeeID);

        String[] columnNames = {"Employee #", "Last Name", "First Name", "SSS", "PhilHealth", "TIN", "Pag-IBIG"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (String[] data : employeeData) {
            String[] rowData = {data[0], data[1], data[2], data[6], data[7], data[8], data[9]};
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> {
            model.setRowCount(0);
            List<String[]> refreshedData = readEmployeeData(csvFilePath, employeeID);
            for (String[] data : refreshedData) {
                String[] rowData = {data[0], data[1], data[2], data[6], data[7], data[8], data[9]};
                model.addRow(rowData);
            }
        });
        buttonPanel.add(refreshButton);

        JButton viewEmployeeButton = new JButton("View Employee");
        viewEmployeeButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String employeeNumber = (String) table.getValueAt(selectedRow, 0);
                List<String[]> refreshedData = readEmployeeData(csvFilePath, employeeID);
                String[] employeeDetails = null;
                for (String[] data : refreshedData) {
                    if (data[0].equals(employeeNumber)) {
                        employeeDetails = data;
                        break;
                    }
                }
                if (employeeDetails != null) {
                    EmployeeDetails employeeDetailsWindow = new EmployeeDetails(employeeNumber, employeeDetails[1], employeeDetails[2], employeeDetails[3], employeeDetails[4], employeeDetails[5], employeeDetails[6], employeeDetails[7], employeeDetails[8], employeeDetails[9], employeeDetails[10], employeeDetails[11], employeeDetails[12], employeeDetails[13], employeeDetails[14], employeeDetails[15], employeeDetails[16], employeeDetails[17], employeeDetails[18]);
                    employeeDetailsWindow.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Employee details not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an employee to view details.", "No Employee Selected", JOptionPane.WARNING_MESSAGE);
            }
        });
        buttonPanel.add(viewEmployeeButton);

        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.addActionListener(e -> {
            EmployeeDetails3 employeeDetailsWindow = new EmployeeDetails3(); // Open EmployeeDetails3 for adding new employees
            employeeDetailsWindow.setVisible(true);
        });
        buttonPanel.add(addEmployeeButton);

        JButton deleteEmployeeButton = new JButton("Delete Employee");
        deleteEmployeeButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String employeeNumber = (String) table.getValueAt(selectedRow, 0);
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    model.removeRow(selectedRow);
                    deleteEmployeeFromCSV(employeeNumber);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select an employee to delete.", "No Employee Selected", JOptionPane.WARNING_MESSAGE);
            }
        });
        buttonPanel.add(deleteEmployeeButton);
        
        // Add Leave Requests button
        JButton leaveRequestsButton = new JButton("Leave Requests");
        leaveRequestsButton.addActionListener(e -> {
            // Open the LeaveRequest form
            new LeaveRequestsTable().setVisible(true);
        });
        buttonPanel.add(leaveRequestsButton); // Add the Leave Requests button before the Logout button


        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            new LogInTest().setVisible(true);
            dispose();
        });

        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(logoutButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private List<String[]> readEmployeeData(String csvFile, String employeeID) {
        List<String[]> employeeData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            boolean headerSkipped = false;
            while ((line = reader.readNext()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }
                String employeeNumber = line[0].trim().replace("#", "");
                if ("admin".equals(employeeID) || employeeNumber.equals(employeeID.trim())) {
                    employeeData.add(line);
                }
            }
        } catch (IOException | com.opencsv.exceptions.CsvValidationException e) {
            e.printStackTrace();
        }
        return employeeData;
    }

    private void deleteEmployeeFromCSV(String employeeID) {
        List<String[]> employeeData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (!line[0].equals(employeeID)) {
                    employeeData.add(line);
                }
            }
        } catch (IOException | com.opencsv.exceptions.CsvValidationException e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            for (String[] data : employeeData) {
                writer.writeNext(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
