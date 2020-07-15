/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Administrator;
import Model.OrderRepository;
import Model.UserRepository;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AbdelRahman Badran , Madoma Diallo 
 */
@SuppressWarnings("serial")
public class AdminAccountSettings extends javax.swing.JFrame {

    private UserRepository adminDets = new UserRepository();
    private OrderRepository orderRepository = new OrderRepository();
    /**
     * Creates new form adminAccountSettings
     */
    public AdminAccountSettings() throws Exception {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) "> 
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminAccountSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAccountSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAccountSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAccountSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         //</editor-fold>
        initComponents();
        
        Administrator admin =  adminDets.readAdminFile();
        adminIdFld.setText(Integer.toString(admin.getAdminId()));
        usernameFld.setText(admin.getAdminName());
        contactNumberFld.setText(admin.getContact());
        emailFld.setText(admin.getEmail());
        passFld.setText(admin.getAdminPass());
        
        orderRepository.getAllOrders();
        salesFld.setText(String.valueOf(orderRepository.getTotalSalesMade()));
        ordersAceeptedFld.setText(String.valueOf(orderRepository.getNumOfAcceptedOrders()));
        ordersRejectedFld.setText(String.valueOf(orderRepository.getNumOfRejectedOrders()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        adminSettingsUpPanel = new javax.swing.JPanel();
        adminSettingsIcon = new javax.swing.JLabel();
        adminSettingsLbl = new javax.swing.JLabel();
        adminSettingsFld = new javax.swing.JTextField();
        adminSettingsPanel = new javax.swing.JPanel();
        salesFld = new javax.swing.JTextField();
        salesLbl = new javax.swing.JLabel();
        ordersRejectedFld = new javax.swing.JTextField();
        ordersRejectedLbl = new javax.swing.JLabel();
        adminSettingsSep = new javax.swing.JSeparator();
        passFld = new javax.swing.JPasswordField();
        confirmPassFld = new javax.swing.JPasswordField();
        ordersAceeptedFld = new javax.swing.JTextField();
        newPassFld = new javax.swing.JPasswordField();
        conformPassLbl = new javax.swing.JLabel();
        ordersAcceptedLbl = new javax.swing.JLabel();
        NewPassLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        updateDetailsBtn = new javax.swing.JButton();
        contactNumberLbl = new javax.swing.JLabel();
        usernameLbl = new javax.swing.JLabel();
        adminIdLbl = new javax.swing.JLabel();
        emailLbl = new javax.swing.JLabel();
        adminSettingsSep1 = new javax.swing.JSeparator();
        emailFld = new javax.swing.JTextField();
        contactNumberFld = new javax.swing.JTextField();
        usernameFld = new javax.swing.JTextField();
        adminIdFld = new javax.swing.JTextField();
        showPassBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminSettingsUpPanel.setBackground(new java.awt.Color(51, 0, 51));
        adminSettingsUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminSettingsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/icons8-services-48.png"))); // NOI18N
        adminSettingsUpPanel.add(adminSettingsIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        adminSettingsLbl.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        adminSettingsLbl.setForeground(new java.awt.Color(255, 255, 255));
        adminSettingsLbl.setText("Administrator Settings");
        adminSettingsUpPanel.add(adminSettingsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        adminSettingsFld.setEditable(false);
        adminSettingsFld.setBackground(new java.awt.Color(51, 0, 51));
        adminSettingsFld.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        adminSettingsFld.setForeground(new java.awt.Color(255, 255, 255));
        adminSettingsFld.setText("Admin");
        adminSettingsFld.setBorder(null);
        adminSettingsFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSettingsFldActionPerformed(evt);
            }
        });
        adminSettingsUpPanel.add(adminSettingsFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 40, 20));

        getContentPane().add(adminSettingsUpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 80));

        adminSettingsPanel.setBackground(new java.awt.Color(255, 255, 255));
        adminSettingsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salesFld.setEditable(false);
        salesFld.setName(""); // NOI18N
        salesFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesFldActionPerformed(evt);
            }
        });
        adminSettingsPanel.add(salesFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 150, -1));

        salesLbl.setText("Sales in Ringgits");
        adminSettingsPanel.add(salesLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        ordersRejectedFld.setEditable(false);
        ordersRejectedFld.setName(""); // NOI18N
        ordersRejectedFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersRejectedFldActionPerformed(evt);
            }
        });
        adminSettingsPanel.add(ordersRejectedFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 150, -1));

        ordersRejectedLbl.setText("Orders Rejected");
        adminSettingsPanel.add(ordersRejectedLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));
        adminSettingsPanel.add(adminSettingsSep, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 510, 10));

        passFld.setEditable(false);
        passFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFldActionPerformed(evt);
            }
        });
        adminSettingsPanel.add(passFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 140, -1));

        confirmPassFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassFldActionPerformed(evt);
            }
        });
        adminSettingsPanel.add(confirmPassFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 140, -1));

        ordersAceeptedFld.setEditable(false);
        ordersAceeptedFld.setName(""); // NOI18N
        ordersAceeptedFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersAceeptedFldActionPerformed(evt);
            }
        });
        adminSettingsPanel.add(ordersAceeptedFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 150, -1));

        newPassFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassFldActionPerformed(evt);
            }
        });
        adminSettingsPanel.add(newPassFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 140, -1));

        conformPassLbl.setText("Confirm Password");
        adminSettingsPanel.add(conformPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        ordersAcceptedLbl.setText("Orders Accepted");
        adminSettingsPanel.add(ordersAcceptedLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        NewPassLbl.setText("New Password");
        adminSettingsPanel.add(NewPassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        passwordLbl.setText(" Password");
        adminSettingsPanel.add(passwordLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        updateDetailsBtn.setBackground(new java.awt.Color(204, 204, 204));
        updateDetailsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/icons8-update-48.png"))); // NOI18N
        updateDetailsBtn.setText("Update");
        updateDetailsBtn.setBorderPainted(false);
        updateDetailsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateDetailsBtn.setFocusPainted(false);
        updateDetailsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        updateDetailsBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        updateDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDetailsBtnActionPerformed(evt);
            }
        });
        adminSettingsPanel.add(updateDetailsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 100, 80));

        contactNumberLbl.setText("Contact Number");
        adminSettingsPanel.add(contactNumberLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        usernameLbl.setText("Username");
        adminSettingsPanel.add(usernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        adminIdLbl.setText("Admin Id");
        adminSettingsPanel.add(adminIdLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        emailLbl.setText("Email");
        adminSettingsPanel.add(emailLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));
        adminSettingsPanel.add(adminSettingsSep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 510, 10));
        adminSettingsPanel.add(emailFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 140, -1));
        adminSettingsPanel.add(contactNumberFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 140, -1));
        adminSettingsPanel.add(usernameFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 140, -1));
        adminSettingsPanel.add(adminIdFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 140, -1));

        showPassBox.setText("Show");
        showPassBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassBoxActionPerformed(evt);
            }
        });
        adminSettingsPanel.add(showPassBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        getContentPane().add(adminSettingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 510, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adminSettingsFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSettingsFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminSettingsFldActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        AdminPanel backToMainAdminPanel = new AdminPanel();
        backToMainAdminPanel.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    
    @SuppressWarnings("deprecation")
    private void updateDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDetailsBtnActionPerformed
        
        Administrator admin = new Administrator();
        UserRepository modifyAdmin = new UserRepository();
        
        try {
        
        String adminName = usernameFld.getText();
        String adminId = adminIdFld.getText();
        String contact = contactNumberFld.getText();
        String email = emailFld.getText();
        
        String adminPass = passFld.getText();
        String newPass = newPassFld.getText();
        String confirmPass = confirmPassFld.getText();

        
        if(admin.validateUpdateDetails(adminName, adminPass, newPass, confirmPass, email, contact, adminId)){
           modifyAdmin.editAdminDetails(adminName, adminPass, newPass, email, contact, adminId);
           
           JOptionPane.showMessageDialog(null, "Profile Successfuly Updated!");
        }
        
        
        } catch (NumberFormatException | IOException ex) {
            Logger.getLogger(AdminAccountSettings.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Sorry, an Error Occured");
            
        }          
    }//GEN-LAST:event_updateDetailsBtnActionPerformed

    
    private void newPassFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassFldActionPerformed

    private void ordersAceeptedFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersAceeptedFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordersAceeptedFldActionPerformed

    private void confirmPassFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassFldActionPerformed

    private void passFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFldActionPerformed

    private void ordersRejectedFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersRejectedFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordersRejectedFldActionPerformed

    private void salesFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salesFldActionPerformed

    private void showPassBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassBoxActionPerformed
        if(showPassBox.isSelected()){
            passFld.setEchoChar((char)0);
            newPassFld.setEchoChar((char)0);
            confirmPassFld.setEchoChar((char)0);
        }
        else{
            passFld.setEchoChar('*');
            newPassFld.setEchoChar('*');
            confirmPassFld.setEchoChar('*');
        }
    }//GEN-LAST:event_showPassBoxActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NewPassLbl;
    private javax.swing.JTextField adminIdFld;
    private javax.swing.JLabel adminIdLbl;
    private javax.swing.JTextField adminSettingsFld;
    private javax.swing.JLabel adminSettingsIcon;
    private javax.swing.JLabel adminSettingsLbl;
    private javax.swing.JPanel adminSettingsPanel;
    private javax.swing.JSeparator adminSettingsSep;
    private javax.swing.JSeparator adminSettingsSep1;
    private javax.swing.JPanel adminSettingsUpPanel;
    private javax.swing.JPasswordField confirmPassFld;
    private javax.swing.JLabel conformPassLbl;
    private javax.swing.JTextField contactNumberFld;
    private javax.swing.JLabel contactNumberLbl;
    private javax.swing.JTextField emailFld;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JPasswordField newPassFld;
    private javax.swing.JLabel ordersAcceptedLbl;
    private javax.swing.JTextField ordersAceeptedFld;
    private javax.swing.JTextField ordersRejectedFld;
    private javax.swing.JLabel ordersRejectedLbl;
    private javax.swing.JPasswordField passFld;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JTextField salesFld;
    private javax.swing.JLabel salesLbl;
    private javax.swing.JCheckBox showPassBox;
    private javax.swing.JButton updateDetailsBtn;
    private javax.swing.JTextField usernameFld;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}