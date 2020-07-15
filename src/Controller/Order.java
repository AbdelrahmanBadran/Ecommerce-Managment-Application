package Controller;

import Model.OrderRepository;
import Model.ProductModel;
import Model.UserRepository;
import java.awt.Component;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class Order extends JTextArea implements TableCellRenderer{ //extended and implement to amke a product order on each line of a cell
    private Customer customer;
    private Customer updatedCustomer;
    private boolean  enoughFunds = false;
    private ProductModel productModel = new ProductModel();
    private OrderRepository orderRepository = new OrderRepository();
    private UserRepository userRepositrory = new UserRepository();
    private Product updatedProduct;
    private int orderID;
    private double  totalOrderCost;
    private String productName, customerName, orderStatus;
    private final String[] status = {"Rejected", "Accepted", "Not Reviewed"};
    private Date orderDate = new Date();
    private String modifiedDate;
    private ArrayList<String> summaryOrderProductInfo = new ArrayList<>();
    
     //<editor-fold defaultstate="collapsed" desc=" Constructors "> 
    public Order(){
    
    }
//    public Order(String productName, String customerName){
//        this.productName = productName;
//        this.customerName = customerName;
//        int randomOrderID = (int) (Math.random() * 200 + 1);
//        this.orderID = randomOrderID;
//        this.orderStatus = status[2];
//        //gets current date
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            orderDate = sdf.parse(sdf.format(new Date()));
//        } catch (ParseException ex) {
//            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
        //<---------- begin of methods used for saving customer order
       public Order(ArrayList<Product> orderItems, String customerName ){
           
        this.customerName = customerName;
        int randomOrderID = (int) (Math.random() * 200 + 1);
        this.orderID = randomOrderID;
        this.orderStatus = status[2];
        //gets current date
        modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(orderDate);
       
        
        for (Product orderItem : orderItems) {
               String name = orderItem.getName();
               int quantity = orderItem.getOrderQuantity(); 
               String details = quantity + " " + name ;
               
                summaryOrderProductInfo.add(details);
           }

    }
       //</editor-fold>
       
       //<editor-fold defaultstate="collapsed" desc=" Getters and Setters for fields "> 

    public boolean isEnoughFunds() {
        return enoughFunds;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getProductName() {
        return productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getOrderDate() {
        return modifiedDate;
    }

    public double getTotalOrderCost() {
        return totalOrderCost;
    }

    public ArrayList<String> getSummaryOrderProductInfo() {
        return summaryOrderProductInfo;
    }

    public void setTotalOrderCost(double totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setSummaryOrderProductInfo(ArrayList<String> summaryOrderProductInfo) {
        this.summaryOrderProductInfo = summaryOrderProductInfo;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    //</editor-fold>
    
    
    public void sufficientFunds(Customer loggedCustomer, double orderTotal) throws IOException{
        customer = loggedCustomer;
        updatedCustomer = this.customer.copyOfCustomer();
        this.totalOrderCost = orderTotal;
        
        double customerFunds = customer.getFunds();
        if (customerFunds < orderTotal){
             JOptionPane.showMessageDialog(null,"You have insufficient funds to make this Order");
        }
        else{
            customerFunds -= orderTotal;
            updatedCustomer.setFunds(customerFunds);
            enoughFunds = true;
            customer.updateProfile(customer, updatedCustomer);
            
        }
    
    }
    
    public void updateItemQuantity(ArrayList<Product> cartItems) throws IOException{
        //first we delete/update the quantity of items from the file
            
            getOrderItemsFullDetails(cartItems);
            ArrayList<Product> allProducts = productModel.getProducts(); // gets all Products in the product file for a view of all the details. cart items products did not have all the fields set.only the fields needed by the table were available
            for (Product product : productsToOrder) {
                int availableQuantity = product.getQuantity();
                for (Product cartItem : cartItems) {
                    if (cartItem.getName().equals(product.getName())) {
                        int requestedQuantity = cartItem.getOrderQuantity();
                        int remainingQuantity = availableQuantity - requestedQuantity; 
                        updatedProduct = product.copyOfProduct();
                        updatedProduct.setQuantity(remainingQuantity);
                        product.updateProduct(product, updatedProduct);                    
                    }
                    
                }
            
        }
            placeOrder(cartItems);

    }
    public void placeOrder(ArrayList<Product> orderItems) throws IOException{
        
        if(orderRepository.doesOrderIDExist(this.orderID)){
            int randomOrderID = (int) (Math.random() * 200 + 1);
            this.orderID = randomOrderID;
             //same order id for each product
        }
            Order order = new Order(orderItems, updatedCustomer.getName());
            order.setTotalOrderCost(this.totalOrderCost);
            orderRepository.writeToOrderFile(order);
 
    }
    
    
    
    private ArrayList<Product> productsToOrder = new ArrayList<>();
    //before this the constructor we created our cart items had half details so we need to retrieve all details
    public void getOrderItemsFullDetails(ArrayList<Product> cartItems) throws IOException{
        
        for (Product cartItem : cartItems) {
            int foundOnce = 0;
            do {                

            ArrayList<Product> allProducts = productModel.getProducts(); // gets all Products in the product file
            String productDetails = productModel.getProductWithName(cartItem.getName());
            String[] values = new String[9];
            values = productDetails.split(",");
            
            Product fullProductDetails = new Product(Integer.parseInt(values[0]),Integer.parseInt(values[4]),Integer.parseInt(values[6]), values[1], values[3], values[7], Category.valueOf(values[5]), Double.parseDouble(values[2]), values[8]);
            
                for (Product product: productsToOrder) {
                    if (product.getName().equals(cartItem.getName())) {
                        foundOnce = 1;
                    }
                    
                }
                productsToOrder.add(fullProductDetails);
            
             } 
            while (foundOnce == 0);
        }
    
    }
    
    //---------------------> end of methods for saving customer orders
    
    
     
    
    private ArrayList<Order> allOrders = new ArrayList<>();
       //history table is used to show all previous orders made by cutomer
    public void populateHistoryTable(DefaultTableModel tableModel, String loggedIncustomerName, JTable table){
        allOrders = orderRepository.getAllOrders();
        setLineWrap(true);
        setWrapStyleWord(true);
        
        table.getColumnModel().getColumn(1).setCellRenderer(this);
        table.setRowHeight(100);
//        for(int i = 0 ; i < tableModel.getRowCount(); i++)
//        {
//            table.setRowHeight(i ,100);
//            
//        }
        
        
        for (int i = 0; i < allOrders.size(); i++){
            String customer = allOrders.get(i).getCustomerName();
            if (customer.equals(loggedIncustomerName)) {
                int orderID = allOrders.get(i).getOrderID();
                ArrayList<String> items = allOrders.get(i).getSummaryOrderProductInfo();
                //to remove braces from being displayed on the table
                StringBuilder builder = new StringBuilder();
                for (String item : items) {
                    builder.append(item);
                    builder.append("\n");
                }
                String itemsString = builder.toString();
                double cost = allOrders.get(i).getTotalOrderCost();
                String status = allOrders.get(i).getOrderStatus();
                String date = allOrders.get(i).getOrderDate();
                
                Object [] data = {orderID, itemsString, cost, status, date };
                tableModel.addRow(data);
            }

        }
    }
    

    
    public void deleteOrderwithID(int orderID){
        
        try {
            String orderToDelete = orderRepository.getLineWithOrderID(orderID);
            //delete comment if approved
            //System.out.println(orderToDelete);
            orderRepository.deleteFromOrderFile(orderToDelete);
        } catch (IOException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((String)value);
//        int height_wanted = (int)getPreferredSize().getHeight();
//        if (height_wanted != table.getRowHeight(row))
//          table.setRowHeight(row, height_wanted);
        return this;
        }
    
     public Order searchOrderInformation(int orderID){
         
         allOrders = orderRepository.getAllOrders();
         Order foundOrder = new Order();
        
         for (int i = 0; i < allOrders.size(); i++){
            int id = allOrders.get(i).getOrderID();
            if(id == orderID){
                foundOrder = allOrders.get(i);
                break;
            }

        }
            return foundOrder;
    }  
}
