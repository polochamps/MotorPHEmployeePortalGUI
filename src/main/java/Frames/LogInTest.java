

package Frames;


import Classes.EmployeeDetails2;
import Classes.CsvReader;
import Classes.EmployeeTable;
import javax.swing.ImageIcon;
import java.util.Map;



/**
 *
 * @author Four Lugtu and Paulo Molina
 */
public class LogInTest extends javax.swing.JFrame {
    private CsvReader csvReader;
    private Map<String, String[]> employees;
    private Map<String, String> passwords; // Change the type to Map<String, String>
    
    

    /**
     * Creates new form LogInTest
     */
    
    public LogInTest() {
        initComponents();
        
        // Provide file paths
        csvReader = new CsvReader("src/main/java/csv/MotorPH Employee Data.csv", "src/main/java/csv/Employee Passwords.csv"); 
        
        // Retrieve employee data
        employees = csvReader.getEmployees(); 
        
        // Retrieve passwords from the "Employee Passwords" CSV
        passwords = csvReader.getPasswords();
        

        setResizable(false);
        
        // Center the frame
        setLocationRelativeTo(null); 
        
        // Set the title of the JFrame
        setTitle("MotorPH Employee Portal");
 
        String imagePath = "src/main/java/images/motorph background.png";
        
        // Create an ImageIcon from the image file
        ImageIcon icon = new ImageIcon(imagePath);
        
        // Set the ImageIcon as the icon for the JLabel
        jLabel1.setIcon(icon);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMaximumSize(new java.awt.Dimension(850, 470));
        jPanel1.setMinimumSize(new java.awt.Dimension(850, 470));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText(" Role:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 420, 50, 40);

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Human Resources", "Operations" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(60, 420, 170, 40);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Employee ID:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(240, 420, 110, 40);

        jTextField1.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        jTextField1.setText("Enter your Employee ID");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(350, 420, 150, 40);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText(" Password:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(500, 420, 90, 40);

        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton1.setText("Log In");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(750, 420, 90, 40);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("     Welcome to MotorPH Employee Portal!");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(440, 0, 390, 40);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("powered by WorkMate™");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(700, 20, 120, 40);

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(590, 420, 150, 40);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
   
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String selectedRole = (String) jComboBox1.getSelectedItem();
        String employeeID = jTextField1.getText().trim(); // Trim whitespace
        String password = new String(jPasswordField1.getPassword());
        
        System.out.println("Selected Role: " + selectedRole);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Password: " + password);

        if (selectedRole.equals("Human Resources")) {
            
        // Check if the user is logged in as admin in Human Resources
            if (employeeID.equals("admin") && password.equals("admin")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Login successful!");
                new EmployeeTable(employeeID).setVisible(true);
                dispose();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Login Failed", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else if (selectedRole.equals("Operations")) {
            
            // Check if the entered Employee ID exists in the employee data map
            if (employees.containsKey(employeeID)) {
                
                // Retrieve the employee data for the entered Employee ID
                String[] employeeData = employees.get(employeeID);
        
                // Retrieve the corresponding password from the passwords map
                String correctPassword = passwords.get(employeeID);
        
                // Check if the entered password matches the correct password
                if (password.equals(correctPassword)) {
                    
                    // If the credentials are correct, display a success message and open the EmployeeDetails2 frame
                    javax.swing.JOptionPane.showMessageDialog(this, "Login successful!");
                    //new EmployeeDetails2(employeeID, employeeData).setVisible(true);
                    // Now, you can call the constructor of EmployeeDetails2 with all required parameters
                    new EmployeeDetails2(employeeID, employeeData[1], employeeData[0], employeeData[2], employeeData[3], employeeData[4], employeeData[5], employeeData[6], employeeData[7], employeeData[8], employeeData[9], employeeData[10], employeeData[11], employeeData[12], employeeData[13], employeeData[14], employeeData[15], employeeData[16], employeeData[17])
                    .setVisible(true);
                    dispose();
            } else {
                    
                // If the password is incorrect, display an error message
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid password. Please try again.", "Login Failed", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
                
            // If the entered Employee ID does not exist, display an error message
            javax.swing.JOptionPane.showMessageDialog(this, "Employee ID not found. Please try again.", "Login Failed", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            LogInTest loginTest = new LogInTest();
            loginTest.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
