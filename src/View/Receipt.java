/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AbdelRahman Badran , Madoma Diallo 
 */
public class Receipt extends javax.swing.JDialog {
    private int orderID ,customerID;
    private String products, customerName, date, address;
    private double total;

    /**
     * Creates new form Receipt
     */
    public Receipt(java.awt.Frame parent, boolean modal,int orderID , String products, double total, String customerName,int customerID,String address, String date) {
        super(parent, modal);
        this.orderID = orderID;
        this.products = products;
        this.total = total;
        this. customerName = customerName;
        this.customerID = customerID;
        this.address = address;
        this.date = date;
        
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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        loadReceipt();
        
        
           this.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dispose();
                    }
                });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        receiptTxtArea = new javax.swing.JTextArea();
        exportBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        receiptTxtArea.setEditable(false);
        receiptTxtArea.setColumns(20);
        receiptTxtArea.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        receiptTxtArea.setRows(5);
        jScrollPane1.setViewportView(receiptTxtArea);

        exportBtn.setBackground(new java.awt.Color(204, 0, 51));
        exportBtn.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        exportBtn.setText("Export to PDF");
        exportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(exportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtnActionPerformed
        try {
            Document document = new Document();
            String fileName = "ReceiptForOrderID"+ orderID;
            PdfWriter.getInstance(document, new FileOutputStream(fileName+".pdf"));
            document.open();
            document.add(new Paragraph(receiptTxtArea.getText()));
                      
            document.close();
            JOptionPane.showMessageDialog(rootPane, "Receipt has been exported to your desktop Succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "An error occured "+ e);
            
        }
        
        
        

    }//GEN-LAST:event_exportBtnActionPerformed

    public void loadReceipt(){
        receiptTxtArea.append("\tOrder  Receipt \n\n" +

            "Order No: " + orderID+ "\n" + "Order Date: " + date+
            "\n==========================\n"+
            "Customer Name:\t" + customerName+"\n" +
            "Customer ID:\t\t" + customerID + "\n" +
            "____________________________\n"+
            "Products:\t\t" + "\n"+products + "\n"+
            "Shipped To:\t\t"+ address+"\n" +
            "_____________________________\n"+
            "Total:\t\t" + total +"\n\n" +
            "\n===========================\n"+
            "Products sold are returnable"

        );
    }
    /**
     * @param args the command line arguments
     */
    
                 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea receiptTxtArea;
    // End of variables declaration//GEN-END:variables
}
