package Controller;


import Model.ProductModel;
import View.AdminPanel;
import View.ManageProduct;
import java.awt.Color;
import java.awt.Component;
//import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;



public class Product {
   private  int productId, quantity, rating, orderQuantity;
   private String name, description, image, packaging;
   private Category category;
   private double price;
   private ProductModel productModel = new ProductModel();
   



   public Product(){

   }

    public Product(int productId, int quantity, int rating, String name, String description, String image, Category category, double price, String packaging) {
        this.productId = productId;
        this.quantity = quantity;
        this.rating = rating;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.image = image;
        this.packaging = packaging;
    }

    //constructor to holded customers requested quantity different from above quantity that represetns stock available
     public Product(  String name,  double price, String packaging, int orderQuantity) {

        this.name = name;
        this.price = price;
        this.packaging = packaging;
        this.orderQuantity = orderQuantity;

    }

         //<editor-fold defaultstate="collapsed" desc=" Getters and Setters for fields "> 
    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    //</editor-fold>

    public Product copyOfProduct(){
        Product copyProductObject = new Product(this.productId, this.quantity, this.rating, this.name, this.description, this.image, this.category, this.price, this.packaging);
    return copyProductObject;
    }

    public boolean validateProductEntry(int  productId, String quantity, String rating, String name, String description, String image, Category category, String price, String packaging){


            if (quantity.equals("") || rating.equals("") || name.equals("") || price.equals("")) {
             JOptionPane.showMessageDialog(null,"One or more fields are left blank");
            return false;
            }

            if (! quantity.matches("[0-9]+") || !rating.matches("[0-9]+")) {
                JOptionPane.showMessageDialog(null,"Stock and Rating must be Integers");
                return false;
            }

            if (!isDouble(price)){
                JOptionPane.showMessageDialog(null,"Price must be a Number");
                return false;
            }
            if (Integer.parseInt(rating) > 5 || Integer.parseInt(rating) < 1 ){
            JOptionPane.showMessageDialog(null, "Rating should be(1-5)");
            return false;
            }
                        
           return true;
        }

  public boolean isDouble(String test){
      try{
          Double.parseDouble(test);
          return true;
      }

      catch(NumberFormatException e){
          return false;
            }
        }

  
  public ImageIcon loadImageToTable(String imagePath, JTable table) 
    {
        
        
        Path pathto = Paths.get(imagePath);
                //path.subpath(1, 3);
                String truncatedPath = pathto.toString();
                
                String newPath = truncatedPath.replaceAll("\\\\", "/");
                
        if (getClass().getResource(newPath) == null) {
            imagePath = "/ProductImages/Products/Default Image.png";
            
        }else{
            imagePath = newPath;
        }
                ImageIcon icn = new ImageIcon(getClass().getResource(imagePath));
                Image img = icn.getImage().getScaledInstance(150, 150,Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
               table.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());
               table.setRowHeight(170);
               return icon;
       
    }
  
   private ArrayList<Product> allProducts;
    public void populateBooksTable( DefaultTableModel tableModel, JTable table) {

        allProducts = productModel.getProducts();

        for (int i = 0; i < allProducts.size(); i++){

            Category type =allProducts.get(i).getCategory();
            if(type == Category.BOOKS){
                String name = allProducts.get(i).getName();
                String description = allProducts.get(i).getDescription();
                double price = allProducts.get(i).getPrice();
                int stock = allProducts.get(i).getQuantity();
                String productImage = allProducts.get(i).getImage();
                //Path path = Paths.get(productImage);
                //JLabel label = new JLabel();
//                Path path = Paths.get(productImage);
//                path.subpath(1, 3);
//                System.out.println(path.subpath(1, 3));
//                productImage = path.subpath(1, 3).toString();
//                System.out.println(productImage);
//                String prod = productImage.replaceAll("\\\\", "/");
//                prod = "/"+ prod;
//                
//                System.out.println(prod);
                
                //ImageIcon icon = new ImageIcon(getClass().getResource("/ProductImages/Default Image.png"));
                
               // label.setIcon(icon);
               //set image
               ImageIcon icon = loadImageToTable(productImage, table);
                
                //System.out.println(icon);

               
                
                Object [] data = {name, description, price, stock, icon};
                tableModel.addRow(data);
                
                
                

            }
        }

    }

    public void populateElectronicsTable( DefaultTableModel tableModel, JTable table){

        allProducts = productModel.getProducts();

        for (int i = 0; i < allProducts.size(); i++){
            Category type =allProducts.get(i).getCategory();
            if(type == Category.ELECTRONICS){
                String name = allProducts.get(i).getName();
                String description = allProducts.get(i).getDescription();
                double price = allProducts.get(i).getPrice();
                int stock = allProducts.get(i).getQuantity();
                String productImage = allProducts.get(i).getImage();
                ImageIcon icon = loadImageToTable(productImage, table);

                Object [] data = {name, description, price, stock, icon };
                tableModel.addRow(data);

            }
        }

    }

    public void populateGamesTable( DefaultTableModel tableModel, JTable table){

        allProducts = productModel.getProducts();

        for (int i = 0; i < allProducts.size(); i++){

            Category type =allProducts.get(i).getCategory();
            if(type == Category.GAMES_TOYS){
                String name = allProducts.get(i).getName();
                String description = allProducts.get(i).getDescription();
                double price = allProducts.get(i).getPrice();
                int stock = allProducts.get(i).getQuantity();
                String productImage = allProducts.get(i).getImage();
                
                ImageIcon icon = loadImageToTable(productImage, table);

                Object [] data = {name, description, price, stock, icon };
                tableModel.addRow(data);

            }
        }

    }

    public void populateSportsTable( DefaultTableModel tableModel, JTable table){

         allProducts = productModel.getProducts();

        for (int i = 0; i < allProducts.size(); i++){

            Category type =allProducts.get(i).getCategory();
            if(type == Category.SPORTS_EQUIPMENT){
                String name = allProducts.get(i).getName();
                String description = allProducts.get(i).getDescription();
                double price = allProducts.get(i).getPrice();
                int stock = allProducts.get(i).getQuantity();
                String productImage = allProducts.get(i).getImage();
                
                ImageIcon icon = loadImageToTable(productImage, table);

                Object [] data = {name, description, price, stock, icon };
                tableModel.addRow(data);

            }
        }

    }

 
        // search table is used to display results when search button is clicked
        public void populateSearchTable( DefaultTableModel tableModel, JTable table){

         allProducts = productModel.getProducts();

        for (int i = 0; i < allProducts.size(); i++){


                String name = allProducts.get(i).getName();
                String description = allProducts.get(i).getDescription();
                double price = allProducts.get(i).getPrice();
                int stock = allProducts.get(i).getQuantity();
                String productImage = allProducts.get(i).getImage();
                
                ImageIcon icon = loadImageToTable(productImage, table);

                Object [] data = {name, description, price, stock, icon };
                tableModel.addRow(data);


        }

    }

    public Product searchProductInformation(String productName){
         allProducts = productModel.getProducts();
         Product foundProduct = new Product();
        for (int i = 0; i < allProducts.size(); i++){


                String name = allProducts.get(i).getName();
                if(productName.equals(name)){
                    foundProduct = allProducts.get(i);
                    break;
                }

        }


            return foundProduct;

    }

    public int getOrderQuantity() {
        return orderQuantity;
    }
    
    //this method is used to deduct the quantity of order items
    public void updateProduct(Product oldProduct, Product updatedProduct) throws IOException{
        String values = Integer.toString(oldProduct.getProductId() )+ "," + oldProduct.getName()+ "," + Double.toString(oldProduct.getPrice())+ "," + oldProduct.getDescription()+ "," +Integer.toString(oldProduct.getQuantity()) + "," + oldProduct.getCategory() + "," + oldProduct.getRating()+ "," + oldProduct.getImage() + "," + oldProduct.getPackaging();
        String updatedValues = Integer.toString(updatedProduct.getProductId() )+ "," + updatedProduct.getName()+ "," + Double.toString(updatedProduct.getPrice())+ "," + updatedProduct.getDescription()+ "," +Integer.toString(updatedProduct.getQuantity()) + "," + updatedProduct.getCategory() + "," + updatedProduct.getRating()+ "," + updatedProduct.getImage() + "," + updatedProduct.getPackaging();
        productModel.updateProductValues(values, updatedValues);
    }

      public class ImageRenderer extends DefaultTableCellRenderer {
      JLabel lbl = new JLabel();
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        lbl.setIcon((ImageIcon)value);
        lbl.setBackground(Color.WHITE);
        lbl.setOpaque(true);
        lbl.setHorizontalAlignment(CENTER);
        return lbl;
      }
    }
             
             
}
