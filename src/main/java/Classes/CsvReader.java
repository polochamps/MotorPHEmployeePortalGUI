

package Classes;


import java.io.*;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReader {
    private String employeeDataFilePath;
    private String passwordFilePath;

    public CsvReader(String employeeDataFilePath, String passwordFilePath) {
        this.employeeDataFilePath = employeeDataFilePath;
        this.passwordFilePath = passwordFilePath;
    }

    public Map<String, String[]> getEmployees() {
        Map<String, String[]> employees = new HashMap<>();
        Map<String, String> passwords = getPasswords(); // Get passwords from CSV

        try (CSVReader reader = new CSVReader(new FileReader(employeeDataFilePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Check if the line contains enough elements
                if (nextLine.length < 2) {
                    System.err.println("Invalid employee data array: " + Arrays.toString(nextLine));
                    continue; // Skip this line
                }
                String employeeID = nextLine[0];
                String[] employeeData = Arrays.copyOfRange(nextLine, 1, nextLine.length);

                // Remove commas from salary and convert to double if the salary field is present
                if (employeeData.length > 11) { // Assuming the salary field is at index 11 (12th column)
                    employeeData[11] = employeeData[11].replace(",", "");
                }

                // Retrieve password for the employeeID
                String password = passwords.get(employeeID);

                // Check if password exists
                if (password == null) {
                    System.err.println("Password not found for employee ID: " + employeeID);
                    continue; // Skip this employee
                }

                // Add password to employee data
                String[] employeeDataWithPassword = Arrays.copyOf(employeeData, employeeData.length + 1);
                employeeDataWithPassword[employeeDataWithPassword.length - 1] = password;

                employees.put(employeeID, employeeDataWithPassword);

                // Print employee data for debugging
                System.out.println("Employee ID: " + employeeID);
                System.out.println("Employee Data: " + Arrays.toString(employeeDataWithPassword));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Map<String, String> getPasswords() {
        Map<String, String> passwords = new HashMap<>();
        try (CSVReader reader = new CSVReader(new FileReader(passwordFilePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length < 2) {
                    System.err.println("Invalid password data array: " + Arrays.toString(nextLine));
                    continue; // Skip this line
                }
                String employeeID = nextLine[0];
                String password = nextLine[1];
                passwords.put(employeeID, password);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return passwords;
    }
}
