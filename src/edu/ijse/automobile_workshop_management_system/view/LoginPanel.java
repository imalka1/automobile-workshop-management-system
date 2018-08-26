package edu.ijse.automobile_workshop_management_system.view;

import edu.ijse.automobile_workshop_management_system.controller.UserAccountController;
import edu.ijse.automobile_workshop_management_system.model.UserAccountDTO;
import edu.ijse.automobile_workshop_management_system.utilities.Validate;
import java.awt.Font;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginPanel extends javax.swing.JPanel {

    public LoginPanel() {
        initComponents();
        customize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        textUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Neuropol X Rg", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Username");
        add(jLabel1);
        jLabel1.setBounds(570, 250, 230, 50);

        textUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUsernameActionPerformed(evt);
            }
        });
        add(textUsername);
        textUsername.setBounds(800, 250, 590, 50);

        jLabel2.setFont(new java.awt.Font("Neuropol X Rg", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(570, 350, 220, 50);

        buttonLogin.setBackground(new java.awt.Color(35, 35, 35));
        buttonLogin.setFont(new java.awt.Font("Neuropol X Rg", 1, 36)); // NOI18N
        buttonLogin.setForeground(new java.awt.Color(255, 191, 5));
        buttonLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonLogin.setText("Login");
        buttonLogin.setOpaque(true);
        buttonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLoginMouseClicked(evt);
            }
        });
        add(buttonLogin);
        buttonLogin.setBounds(850, 480, 330, 70);

        textPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPasswordActionPerformed(evt);
            }
        });
        add(textPassword);
        textPassword.setBounds(800, 350, 590, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLoginMouseClicked
        checkValidation();
    }//GEN-LAST:event_buttonLoginMouseClicked
    
    private void textPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPasswordActionPerformed
        checkValidation();
    }//GEN-LAST:event_textPasswordActionPerformed

    private void textUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUsernameActionPerformed
        checkValidation();
    }//GEN-LAST:event_textUsernameActionPerformed
    private void checkValidation(){
        try {
            boolean userNameV = false;
            boolean passwordV = false;
            String password = String.valueOf(textPassword.getPassword());
            String[]s=UserAccountController.searchAccount(new UserAccountDTO(textUsername.getText(), password));
            if (textUsername.getText().equals(s[0]) && !(s[0].equals("NO"))) {
                userNameV = true;
            }
            if (Validate.encryptPassword(password).equals(s[1]) && !(s[1].equals("NO"))) {
                passwordV = true;
            }
            if(!(userNameV) && !(passwordV)){
                JOptionPane.showMessageDialog(null, "Incorrect Username & Password", "Warning", 2);
            }
            if (userNameV && passwordV && s[2].equals("0")) {
                MainPanel.getMainPanel().managePanel(0);
            }else if (userNameV && passwordV && s[2].equals("1")) {
                MainPanel.getMainPanel().managePanel(1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void clearText(){
        textUsername.setText("");
        textPassword.setText("");
    }
    private void customize() {
        textUsername.setFont(new Font("", 0, 25));
        textPassword.setFont(new Font("", 0, 25));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel buttonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}
