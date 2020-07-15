package Model;

import Controller.Order;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// Class that deals with all file accessing ( retrieval, editing , deleting, saving ) of Orders.txt file
public class OrderRepository {
    private File orderFile = new File("Orders.txt"); 
    private ArrayList<Order> allOrders = new ArrayList<>();
    private BufferedReader readFile;
    private UserRepository repo = new UserRepository();
    private  int numberOfOrders, numOfAcceptedOrders, numOfRejectedOrders;
    private double totalSalesMade;

    public int getNumOfAcceptedOrders() {
        return numOfAcceptedOrders;
    }

    public int getNumOfRejectedOrders() {
        return numOfRejectedOrders;
    }

    public double getTotalSalesMade() {
        return totalSalesMade;
    }
    
    public ArrayList<Order> getListOfAllOrders(){
        return this.allOrders;
    }
    public void importOrders(JTable table){
            try {
                FileReader inFileReader = new FileReader(orderFile);
                BufferedReader readFile = new BufferedReader(inFileReader);
            
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                Object[] lines = readFile.lines().toArray();
                
                for (Object line : lines) {
                    String[] row = line.toString().split(":");
                    model.addRow(row);
                }
        } catch (FileNotFoundException e) {
        }
    }
    
    //get all Orders from file
    //use same method to display orders for admin 
    public ArrayList<Order> getAllOrders(){
        
            ArrayList<Order> allOrders = new ArrayList<>();
            try {
            readFile = new BufferedReader(new FileReader(orderFile));
            String lineWithOrderInfo;
            double totalSales = 0.0;
            int numOfAcceptedOrders = 0, numOfRejectedOrders = 0;
            
            while((lineWithOrderInfo = readFile.readLine()) != null ){
                String[] values = lineWithOrderInfo.split(":");
                Order order = new Order();
                try {
                    int ID = Integer.parseInt(values[0]);
                    order.setOrderID(ID);
                } catch (NumberFormatException ex) {
                }
                
                
                String[] products = values[1].split(",|\\[|\\]");
                ArrayList<String> orderSummary = new ArrayList<>();
                products = Arrays.copyOfRange(products, 1, products.length);
                for (String str : products) {   
                        orderSummary.add(str);
                }
                order.setSummaryOrderProductInfo(orderSummary);
                order.setCustomerName(values[2]);
                order.setOrderStatus(values[3]);
                order.setTotalOrderCost(Double.parseDouble(values[4]));
                //get total sales of accepted orders
                if (values[3].equals("Accepted")) {
                    totalSales += Double.parseDouble(values[4]);
                    numOfAcceptedOrders++;
                    
                }//get total of rejected orders
                else if (values[3].equals("Rejected")) {
                    numOfRejectedOrders++;
                    
                }
                order.setModifiedDate(values[5]);
                
                allOrders.add(order);    
            }
            this.totalSalesMade = totalSales;
            this.numOfAcceptedOrders = numOfAcceptedOrders;
            this.numOfRejectedOrders = numOfRejectedOrders;
            this.allOrders = new ArrayList<>(allOrders);
             readFile.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OrderRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
            return allOrders;
    }

    
  public boolean doesOrderIDExist(int orderId)throws IOException{
     String[] values = new String[6];
    BufferedReader bfrReader = new BufferedReader(new FileReader(orderFile));
    String line = "";
    while ((line = bfrReader.readLine()) != null) {
        values = line.split(":");
        if (Integer.parseInt(values[0]) == orderId) {
                return true;
        }          
    }     
    return false;
}
  
    public String getLineWithOrderID(int orderId)throws IOException{
     String[] values = new String[6];
    BufferedReader bfrReader = new BufferedReader(new FileReader(orderFile));
    String line = "";
    while ((line = bfrReader.readLine()) != null) {
        values = line.split(":");
        if (Integer.parseInt(values[0]) == orderId) {
            //System.out.println(line);
                break;
        }          
    }     
    return line;
}


  
       private FileWriter fileWriter;
     private BufferedWriter bufferWriter;
     public void writeToOrderFile(Order order) throws IOException{

        if (repo.doesFileExist(orderFile)){
            fileWriter = new FileWriter(orderFile, true);
             bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(order.getOrderID()+":" + order.getSummaryOrderProductInfo()+":"+ order.getCustomerName()
                               + ":" + order.getOrderStatus()+":"+ order.getTotalOrderCost()+ ":" + order.getOrderDate());
            bufferWriter.newLine();
            bufferWriter.close();
        }
        bufferWriter.close();
        fileWriter.close();

    } 
     
     
      public void updateOrderFile(ArrayList<String> list ) throws IOException{

           FileWriter outFileWriter;
           BufferedWriter writeFile;
           //System.out.println("this is working");
        if (repo.doesFileExist(orderFile)){
            //System.out.println("but not this");
            outFileWriter = new FileWriter("Orders.txt",false);
            writeFile = new BufferedWriter(outFileWriter);
            for (String line: list)
            {
              
                writeFile.write(line);
                //writeFile.write(line.getOrderID()+":" + line.getSummaryOrderProductInfo()+":"+ line.getCustomerName()+ ":" + line.getOrderStatus()+":"+ line.getTotalOrderCost()+ ":" + line.getOrderDate());
                writeFile.newLine();
            }
            writeFile.close();
            outFileWriter.close();
        }


    }
      
      private ArrayList<String> orderslist = new ArrayList<>();
        //reads all product file and saves to athe above array list
    public void readOrderFileToDelete(){

        try (BufferedReader br = new BufferedReader(new FileReader(orderFile)))
        {
            String sCurrentLine;
            int numofOrders = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                orderslist.add(sCurrentLine);
                numofOrders++;
            }
            br.close();
            this.numberOfOrders = numofOrders;

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

      public void deleteFromOrderFile(String search) throws IOException{
         
         readOrderFileToDelete();
 
        for(int i = 0; i < orderslist.size(); i++) {
            if(orderslist.get(i).toString().equals(search)) {
                System.out.println(i);
                orderslist.remove(i);
                updateOrderFile(orderslist);
            }
        }//System.out.println("out of " + this.allOrders);
    }
 public void adminOrderReply(String prevOrderLine, String orderLine) throws IOException{
         
         readOrderFileToDelete();
 
        for(int i = 0; i < orderslist.size(); i++) {
            if(orderslist.get(i).toString().equals(prevOrderLine)) {
                orderslist.set(i, orderLine);
                updateOrderFile(orderslist);
            }
        }//System.out.println("out of " + this.allOrders);
    }
      
      public void importOrders(JTable table, DefaultTableModel model) throws FileNotFoundException{
          
          readFile = new BufferedReader(new FileReader(orderFile));
          
          model = (DefaultTableModel) table.getModel();
          Object[] lines = readFile.lines().toArray();
          for (int i = 0; i < lines.length; i++){
              String [] allDetails = lines[i].toString().split(":");
              String[] row = new String[5];
              row[0]= allDetails[0];
              row[1] = allDetails[2];
              row[2]= allDetails[4];
              row[3] = allDetails[5];
              row[4] = allDetails[3];
              model.addRow(row);
          }
    }
}

