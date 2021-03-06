/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Customer;
import java.awt.Window;
//import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author AbdelRahman Badran , Madoma Diallo 
 */
@SuppressWarnings("serial")
public class LogOutUser extends javax.swing.JDialog {
    private Customer customer = new Customer();
    /**
     * Creates new form LogOutUser
     * 
     * @param parent
     * @param modal
     * @param customer
     */
    public LogOutUser(java.awt.Frame parent, boolean modal, Customer customer) {
        super(parent, modal);
        this.customer = customer;
         //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) "> 
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogOutUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogOutUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogOutUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogOutUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        signedInuserLbl.setText(this.customer.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        signedInuserLbl = new javax.swing.JLabel();
        goBackButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        userPicLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Notification");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 12, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signedInuserLbl.setBackground(new java.awt.Color(255, 255, 255));
        signedInuserLbl.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        signedInuserLbl.setForeground(new java.awt.Color(0, 77, 64));
        signedInuserLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(signedInuserLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 170, 24));

        goBackButton.setBackground(new java.awt.Color(255, 102, 0));
        goBackButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        goBackButton.setForeground(new java.awt.Color(255, 255, 255));
        goBackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/icons8_Go_Back_24px.png"))); // NOI18N
        goBackButton.setText("Go Back");
        goBackButton.setBorder(null);
        goBackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });
        jPanel2.add(goBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 150, 40));

        logOutButton.setBackground(new java.awt.Color(255, 102, 0));
        logOutButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/Exit.png"))); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.setBorder(null);
        logOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        jPanel2.add(logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 150, 40));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 77, 64));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("You're signed in as:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 170, -1));

        userPicLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/icons8-customer-48.png"))); // NOI18N
        jPanel2.add(userPicLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 450, 210));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        //this.dispose();
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to LogOut?");
        if (dialogResult == JOptionPane.YES_OPTION){
            this.dispose();
            System.gc();
            Window win [] = Window.getWindows();
            for (Window win1 : win) {
                win1.dispose();
            }
        MainPageView newFrame = new MainPageView();
           newFrame.setVisible(true);
        }
        
    }//GEN-LAST:event_logOutButtonActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        this.dispose();
        

    }//GEN-LAST:event_goBackButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel signedInuserLbl;
    private javax.swing.JLabel userPicLabel;
    // End of variables declaration//GEN-END:variables
}
