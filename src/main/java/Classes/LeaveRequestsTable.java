package Classes;

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

public class LeaveRequestsTable extends JFrame {

    private final String csvFilePath = "src/main/java/csv/Leave Requests Table.csv";
    private JTable table;
    private DefaultTableModel model;

    public LeaveRequestsTable() {
        setTitle("Leave Requests Table - powered by WorkMate™");
        setSize(800, 625);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Only closes the active window
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        // Table
        String[] columnNames = {"Employee Name", "Leave Type", "Start Date", "End Date", "Status"};
        model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make table cells non-editable
            }
        };

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Load data from CSV
        loadCSVData();

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> {
            model.setRowCount(0); // Clear existing data
            loadCSVData(); // Reload data from CSV
        });

        JButton approveButton = new JButton("Approve");
        approveButton.addActionListener(e -> updateStatus("Approved"));

        JButton rejectButton = new JButton("Reject");
        rejectButton.addActionListener(e -> updateStatus("Rejected"));

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            new LogInTest().setVisible(true);
            dispose();
        });

        buttonPanel.add(refreshButton);
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);
        buttonPanel.add(logoutButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    private void loadCSVData() {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            boolean headerSkipped = false;
            while ((line = reader.readNext()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue; // Skip header
                }
                model.addRow(line);
            }
        } catch (IOException | com.opencsv.exceptions.CsvValidationException e) {
            e.printStackTrace();
        }
    }

    private void updateStatus(String status) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.setValueAt(status, selectedRow, 4);
            saveUpdatedCSV();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void saveUpdatedCSV() {
        List<String[]> data = new ArrayList<>();
        // Add header
        data.add(new String[]{"Employee Name", "Leave Type", "Start Date", "End Date", "Status"});
        // Add rows
        for (int i = 0; i < model.getRowCount(); i++) {
            String[] row = new String[model.getColumnCount()];
            for (int j = 0; j < model.getColumnCount(); j++) {
                row[j] = model.getValueAt(i, j).toString();
            }
            data.add(row);
        }
        // Write to CSV
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            writer.writeAll(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LeaveRequestsTable());
    }
}
