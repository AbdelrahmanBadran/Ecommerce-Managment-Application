package Model;

import Controller.Category;
import Controller.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductModel {


    private ArrayList<Product> allProducts;

    private File productFile = new File("Products.txt");

    private FileReader inFileReader;
    private FileWriter outFileWriter;

    private BufferedReader readFile;
    private BufferedWriter writeFile;

    private String lineWithProductInfo;

    private int numberOfProducts;

    //private String[] allDetails;



    // might not need to get all products unless a part of gui needs it. JTable can be used instead for this application
    public ArrayList<Product> getProducts() {
        ArrayList<Product> allItems = new ArrayList<>();
        try {
            readFile = new BufferedReader(new FileReader (productFile));

            while ((lineWithProductInfo = readFile.readLine()) != null) {
                String[ ] values = lineWithProductInfo.split(",");
                Product product = new Product();
                product.setProductId(Integer.parseInt(values[0]));
                product.setName(values[1]);
                product.setPrice(Double.parseDouble(values[2]));
                product.setDescription(values[3]);
                product.setQuantity(Integer.parseInt(values[4]));
                product.setCategory(Category.valueOf(values[5]));
                product.setRating(Integer.parseInt(values[6]));
                product.setImage(values[7]);
                product.setPackaging(values[8]);
                allItems.add(product);
            }

            allProducts = new ArrayList<>(allItems);


            readFile.close();

        }
        catch (IOException e) {
            System.exit(0);
        }
        return allItems;


   }
    private String[] values = new String[9];

    public String getProductWithName(String productName) throws IOException{ //return string
        
        BufferedReader bfrReader = new BufferedReader(new FileReader("Products.txt"));
        String line = "";
        while ((line = bfrReader.readLine()) != null) {
            values = line.split(",");
            if (values[1].equals(productName)) {
                    break;
            }
        }

        return line;

    }
    //Getter for the field all products
    public ArrayList<Product> getAllProducts() {
        return allProducts;
    }


    public void saveNewProduct(Product product){
        try {
            outFileWriter = new FileWriter(productFile,true);
            writeFile = new BufferedWriter(outFileWriter);

            writeFile.write( product.getProductId()+ "," + product.getName() + "," + product.getPrice()+
                    "," + product.getDescription()+ "," +  product.getQuantity()+ "," + product.getCategory()
                    + "," +  product.getRating() + "," + product.getImage() + "," + product.getPackaging());
            writeFile.newLine();

            writeFile.close();
            outFileWriter.close();

        } catch (IOException | NumberFormatException e) {
             Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE,null,e);

        }

    }

    public void importProducts(JTable table, DefaultTableModel model){
            try {
                inFileReader = new FileReader(productFile);
                readFile = new BufferedReader(inFileReader);

                model = (DefaultTableModel) table.getModel();
                Object[] lines = readFile.lines().toArray();
                
                for (int i = 0; i < lines.length; i++){
                    String [] allDetails = lines[i].toString().split(",");
                    String[] row = new String[3];
                    row[0]= allDetails[1];
                    row[1] = allDetails[5];
                    row[2]= allDetails[4];

                    model.addRow(row);
                }
                

        } catch (FileNotFoundException e) {
                Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE,null,e);
        }
    }



    //Added thesee three methods to delete product and update
        private UserRepository repo = new UserRepository();


   private ArrayList<String> productList = new ArrayList<>();
        //reads all product file and saves to athe above array list
    public void readProductsFile(){

        try (BufferedReader br = new BufferedReader(new FileReader(productFile)))
        {
            String sCurrentLine;
            int numofProducts = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                productList.add(sCurrentLine);
                numofProducts++;
            }
            br.close();
            this.numberOfProducts = numofProducts;

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

     public void deleteFromProductFile(String search) throws IOException{
         readProductsFile();
        for(int i = 0; i< productList.size(); i++){
            if(productList.get(i).equals(search)){
                productList.remove(i);
                repo.updateFileContent(productList,productFile);
            }
        }
    }
     //used for ordering to deduct quantity of items
          public void updateProductValues(String search, String update) throws IOException{
              if (productList.isEmpty()) {
                  readProductsFile();
              }

            int valFound = 0;
            for(int i = 0; i < productList.size(); i++){
                if(productList.get(i).equals(search)){
                    productList.set(i, update);
                    valFound+= 1;
                    break;
                }

            }
            if(valFound == 1){
               repo.updateFileContent(productList,productFile);
            }

    }

public int getNumberOfProducts(){
    readProductsFile();
    return numberOfProducts;
    
}
}
