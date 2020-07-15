/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Category;
import Controller.Product;
import Model.ProductModel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author AbdelRahman Badran , Madoma Diallo
 */
public class AddNewProduct extends javax.swing.JDialog {
    private ProductModel productModel = new ProductModel();
    private DefaultTableModel tableModel = new DefaultTableModel();
    int productId = productModel.getNumberOfProducts() + 1;

    /**
     * Creates new form AddNewProduct
     */
    public AddNewProduct(java.awt.Frame parent, boolean modal, DefaultTableModel model) {
        super(parent, modal);
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        this.tableModel = model;

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        productIdField.setText(Integer.toString(productId));
        loadImage();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        productDetailsPanel = new javax.swing.JPanel();
        productNameLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        stockLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        productNameField = new javax.swing.JTextField();
        productDetailsUpPanel = new javax.swing.JPanel();
        productDetailsIcon = new javax.swing.JLabel();
        productDetailsLbl = new javax.swing.JLabel();
        chooseImageFileBtn = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox<>();
        descriptionLabel = new javax.swing.JLabel();
        productDescriptionPane = new javax.swing.JScrollPane();
        productDescriptionTextArea = new javax.swing.JTextArea();
        addProductBtn = new javax.swing.JButton();
        chooseFileField = new javax.swing.JTextField();
        addImageIcon = new javax.swing.JLabel();
        packagingLabel = new javax.swing.JLabel();
        packagingChoiceComboBox = new javax.swing.JComboBox<>();
        cancelProductBtn = new javax.swing.JButton();
        ratingLbl = new javax.swing.JLabel();
        ratingFld = new javax.swing.JTextField();
        productIdLabel = new javax.swing.JLabel();
        productIdField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productDetailsPanel.setBackground(new java.awt.Color(255, 255, 255));
        productDetailsPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                productDetailsPanelPropertyChange(evt);
            }
        });
        productDetailsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productNameLabel.setText("Product Name");
        productDetailsPanel.add(productNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        priceLabel.setText("Price");
        productDetailsPanel.add(priceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        stockLabel.setText("Stock");
        productDetailsPanel.add(stockLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, 20));

        categoryLabel.setText("Category");
        productDetailsPanel.add(categoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });
        productDetailsPanel.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 110, -1));

        stockField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockFieldActionPerformed(evt);
            }
        });
        productDetailsPanel.add(stockField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 60, -1));

        productNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameFieldActionPerformed(evt);
            }
        });
        productDetailsPanel.add(productNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 160, -1));

        productDetailsUpPanel.setBackground(new java.awt.Color(51, 0, 51));
        productDetailsUpPanel.setForeground(new java.awt.Color(51, 0, 51));
        productDetailsUpPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                productDetailsUpPanelPropertyChange(evt);
            }
        });
        productDetailsUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productDetailsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/icons8-product-48.png"))); // NOI18N
        productDetailsUpPanel.add(productDetailsIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 20, -1, -1));

        productDetailsLbl.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        productDetailsLbl.setForeground(new java.awt.Color(255, 255, 255));
        productDetailsLbl.setText("Product Details");
        productDetailsUpPanel.add(productDetailsLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        productDetailsPanel.add(productDetailsUpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 90));

        chooseImageFileBtn.setBackground(new java.awt.Color(255, 255, 255));
        chooseImageFileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/icons8-image-file-48.png"))); // NOI18N
        chooseImageFileBtn.setText("Choose Image");
        chooseImageFileBtn.setBorderPainted(false);
        chooseImageFileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseImageFileBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        chooseImageFileBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        chooseImageFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImageFileBtnActionPerformed(evt);
            }
        });
        productDetailsPanel.add(chooseImageFileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 120, 90));

        categoryComboBox.setBackground(new java.awt.Color(204, 204, 204));
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Electronics", "Games_Toys", "Books", "Sports_Equipment" }));
        categoryComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        productDetailsPanel.add(categoryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 160, -1));

        descriptionLabel.setText("Description ");
        productDetailsPanel.add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        productDescriptionTextArea.setColumns(20);
        productDescriptionTextArea.setRows(5);
        productDescriptionPane.setViewportView(productDescriptionTextArea);

        productDetailsPanel.add(productDescriptionPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 260, 100));

        addProductBtn.setBackground(new java.awt.Color(255, 255, 255));
        addProductBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        addProductBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/icons8-save-close-48.png"))); // NOI18N
        addProductBtn.setText("Add Product");
        addProductBtn.setBorderPainted(false);
        addProductBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProductBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addProductBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        addProductBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });
        productDetailsPanel.add(addProductBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 130, 90));
        productDetailsPanel.add(chooseFileField, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 160, -1));

        addImageIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addImageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/icons8-add-image-48.png"))); // NOI18N
        addImageIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        productDetailsPanel.add(addImageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 220, 160));

        packagingLabel.setText("Packaging");
        productDetailsPanel.add(packagingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        packagingChoiceComboBox.setBackground(new java.awt.Color(204, 204, 204));
        packagingChoiceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Non-Fragile", "Fragille" }));
        packagingChoiceComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        productDetailsPanel.add(packagingChoiceComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 160, -1));

        cancelProductBtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelProductBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductImages/icons8-delete-bin-48.png"))); // NOI18N
        cancelProductBtn.setText("Cancel");
        cancelProductBtn.setBorderPainted(false);
        cancelProductBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelProductBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelProductBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelProductBtnActionPerformed(evt);
            }
        });
        productDetailsPanel.add(cancelProductBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 90, -1));

        ratingLbl.setText("Rating (1-5)");
        productDetailsPanel.add(ratingLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, 20));

        ratingFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ratingFldActionPerformed(evt);
            }
        });
        productDetailsPanel.add(ratingFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 40, -1));

        productIdLabel.setText("Product ID");
        productDetailsPanel.add(productIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        productIdField.setEditable(false);
        productIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdFieldActionPerformed(evt);
            }
        });
        productDetailsPanel.add(productIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 160, -1));

        getContentPane().add(productDetailsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

    private void stockFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockFieldActionPerformed

    private void productNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameFieldActionPerformed


    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtnActionPerformed

        String cat = ((String) categoryComboBox.getSelectedItem()).toUpperCase();
        Category category = Category.valueOf(cat.toUpperCase());
        Product isValidProduct = new Product();

        if (isValidProduct.validateProductEntry(productId, stockField.getText(), ratingFld.getText(), productNameField.getText(),
            productDescriptionTextArea.getText(), chooseFileField.getText(), category, priceField.getText(), packagingChoiceComboBox.getSelectedItem().toString())){

            if(chooseFileField.getText().equals("")){
                chooseFileField.setText("src/ProductImages/Default Image.png");
                JOptionPane.showMessageDialog(null, "The default image will be used for this product");
            }

       Product product = new Product(productId, Integer.parseInt(stockField.getText()), Integer.parseInt(ratingFld.getText()), productNameField.getText(),
       productDescriptionTextArea.getText(), chooseFileField.getText(), category, Double.parseDouble(priceField.getText()), packagingChoiceComboBox.getSelectedItem().toString());

       productModel.saveNewProduct(product);
       JOptionPane.showMessageDialog(null, "Product Added Successfully");

       String row[] = new String[3];
       row[0]= product.getName();
       row[1] = cat;
       row[2]= Integer.toString(product.getQuantity());
       tableModel.addRow(row);

       productIdField.setText("");
       stockField.setText("");
       ratingFld.setText("");
       productNameField.setText("");
       productDescriptionTextArea.setText("");
       chooseFileField.setText("");
       categoryComboBox.setSelectedIndex(0);
       priceField.setText("");
       packagingChoiceComboBox.setSelectedIndex(0);
       chooseFileField.setText("");

       }

    }//GEN-LAST:event_addProductBtnActionPerformed

    private void ratingFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ratingFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ratingFldActionPerformed

    private void productIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdFieldActionPerformed

    private void cancelProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelProductBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelProductBtnActionPerformed

    private void productDetailsUpPanelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_productDetailsUpPanelPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_productDetailsUpPanelPropertyChange

    private void productDetailsPanelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_productDetailsPanelPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_productDetailsPanelPropertyChange

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        AdminPanel refresh = new AdminPanel();
        refresh.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void chooseImageFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImageFileBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseImageFileBtnActionPerformed

    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon productImage = new ImageIcon(ImagePath);
        Image img = productImage.getImage();
        Image newImg = img.getScaledInstance(addImageIcon.getWidth(), addImageIcon.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addImageIcon;
    private javax.swing.JButton addProductBtn;
    private javax.swing.JButton cancelProductBtn;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextField chooseFileField;
    private javax.swing.JButton chooseImageFileBtn;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JComboBox<String> packagingChoiceComboBox;
    private javax.swing.JLabel packagingLabel;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JScrollPane productDescriptionPane;
    private javax.swing.JTextArea productDescriptionTextArea;
    private javax.swing.JLabel productDetailsIcon;
    private javax.swing.JLabel productDetailsLbl;
    private javax.swing.JPanel productDetailsPanel;
    private javax.swing.JPanel productDetailsUpPanel;
    private javax.swing.JTextField productIdField;
    private javax.swing.JLabel productIdLabel;
    private javax.swing.JTextField productNameField;
    private javax.swing.JLabel productNameLabel;
    private javax.swing.JTextField ratingFld;
    private javax.swing.JLabel ratingLbl;
    private javax.swing.JTextField stockField;
    private javax.swing.JLabel stockLabel;
    // End of variables declaration//GEN-END:variables

   
    public void chooseImageFile(){
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);

        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getPath();
            addImageIcon.setIcon(ResizeImage(path));
            
            // Path pathto = Paths.get(path);
            //path.subpath(1, 3);
            
            String truncatedPath = after(path, "src");
            chooseFileField.setText(truncatedPath);
//            System.out.println(truncatedPath);
//            String newPath = truncatedPath.replaceAll("\\\\", "/");
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "No Image Chosen!");
        }
   }


public void loadImage(){
    chooseImageFileBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
        chooseImageFile();
        }
        });

}

public String after(String value, String a) {
        // Returns a substring containing all characters after a string.
        int posA = value.lastIndexOf(a);
        if (posA == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= value.length()) {
            return "";
        }
        return value.substring(adjustedPosA);
    }
}