package Model;

import Controller.Administrator;
import Controller.Customer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Controller.Administrator;

public class UserRepository {

    private String pathName;
    private boolean valuesFound = false;
    private ArrayList <Customer> allCustomers;  // list to store the customer file in customer object form
    private FileWriter fileWriter;
     private BufferedWriter bufferWriter;
     private int numberOfCustomers;
     private Scanner scanner;
     private File adminFile = new File("Admin.txt");
     private File customerFile = new File("Customer.txt");

     
     //admin methods
     public void writeToAdminFile(Administrator Admin) throws IOException{

        if(doesFileExist(adminFile))
        {
            fileWriter = new FileWriter("Admin.txt");
            bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(Admin.getAdminName()  + "," + Admin.getAdminPass() + "," + Admin.getAdminId()  + "," + Admin.getContact() + "," + Admin.getEmail());
            bufferWriter.close();
        }
    }


    public Administrator readAdminFile() throws Exception {
        BufferedReader bfrReader = new BufferedReader(new FileReader("Admin.txt"));
        String line = "";
        line = bfrReader.readLine();
        //System.out.println(line);
        Administrator adm = new Administrator();

        try {
            String[] values = line.split(",");
            adm.setAdminName(values[0]);
            adm.setAdminPass(values[1]);
            adm.setAdminId(Integer.parseInt(values[2]));
            adm.setContact(values[3]);
            adm.setEmail(values[4]);

            }
            catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
            }

        bfrReader.close();

        return adm;

	}

        public void editAdminDetails(String adminName, String adminPass, String newPass, String email, String contact, String adminId) throws IOException{
        
        Administrator modifyAdmin = new Administrator();
        
        modifyAdmin.setAdminName(adminName);
        modifyAdmin.setContact(contact);
        modifyAdmin.setEmail(email);
        modifyAdmin.setAdminId(Integer.parseInt(adminId));
        
        if(newPass.equals(""))
        {
            modifyAdmin.setAdminPass(adminPass);
        }
        else{
            modifyAdmin.setAdminPass(newPass);
        }
        
        writeToAdminFile(modifyAdmin);
    }
    
        
   // Customer methods
    public void writeToCustomerFile(Customer Customer) throws IOException{

        if (doesFileExist(customerFile)){
            fileWriter = new FileWriter("Customer.txt", true);
            bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(Customer.getName()  + "," + Customer.getPassword() + "," + Customer.getEmail()  + "," + Customer.getAddress() + "," +Customer.getFunds() +","+Customer.getContact() + "," + Customer.getId()+"\n");
            bufferWriter.close();
        }
        bufferWriter.close();
        fileWriter.close();

    }
    
    //write method for deleteing doesnt append but rather adds the list with the deleted line
    public void updateFileContent(ArrayList<String> list, File file) throws IOException{

        if (doesFileExist(customerFile)){
            FileWriter FW = new FileWriter(file,false);
             
           BufferedWriter  BW = new BufferedWriter(FW);
            for(String line: list)
            {
                BW.write(line);
                BW.newLine();       
                
            }
            BW.close();
            FW.close();
        }
        
        

    }

    //list to store the file in string form
    private ArrayList<String> customerlist = new ArrayList<>();
    public void readCustomerFile(){
        
        try (BufferedReader br = new BufferedReader(new FileReader("Customer.txt")))
        {
            String sCurrentLine;
            int numofCustomers = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                customerlist.add(sCurrentLine);
                numofCustomers++;
            }
            br.close();
            this.numberOfCustomers = numofCustomers;

        } catch (IOException e) {
            e.printStackTrace();
            
        }
          
    }
    
   
    //String to search has to be Customer.getName()  + "," + Customer.getPassword() + "," + Customer.getEmail()  + "," + Customer.getAddress() + "," +Customer.getFunds() +","+Customer.getContact() + "," + Customer.getId()
    //update has to be same but after setting the value to something else
     public void updateCustomerValues(String search, String update) throws IOException{
        readCustomerFile();
        int valFound = 0;
        for(int i = 0; i < customerlist.size(); i++){
            if(customerlist.get(i).equals(search)){
                customerlist.set(i, update);
                valFound++;
               // break;   
            }
           
        }
        if(valFound == 1){
            updateFileContent(customerlist,customerFile);
        }
        else{
            JOptionPane.showMessageDialog(null, "Could Not Update");
        }
        

        
    }
    
   
    
    public Customer searchCustomerWithName(String saerch) throws Exception{

        BufferedReader bfrReader = new BufferedReader(new FileReader("Customer.txt"));
        String line = "";
        bfrReader.readLine();

        Customer cust = new Customer();

        while ((line = bfrReader.readLine()) != null) {            
                String[] details = line.split(",");
                if (details[0].equals(saerch)){
                    cust.setName(details[0]);
                    cust.setPassword(details[1]);
                    cust.setEmail(details[2]);
                    cust.setAddress(details[3]);
                    cust.setFunds(Double.parseDouble(details[4]));
                    cust.setContact(details[5]);
                    cust.setId(Integer.parseInt(details[6]));
                    break;
                }
            }//should return something if no customer is returened just for fun
        bfrReader.close();
        return cust;
    }


    public boolean doesFileExist(File file){
        if(file.exists()){
           return true;
        }
        else
        {
            try {
                file.createNewFile();
                return true;
            } catch (IOException e) {
                e.getMessage();
                System.exit(0);
            }
            return false;
        }
    }
    private String[] values = new String[7];
    
    public String searchCustomer(String username, String password) throws IOException{ //return string
        BufferedReader bfrReader = new BufferedReader(new FileReader("Customer.txt"));
        String line = "";

        //line = bfrReader.readLine();
        while ((line = bfrReader.readLine()) != null) {
            values = line.split(",");

            if (values[0].equals(username) && values[1].equals(password)) {

                    break;
                    //System.out.println(values);
            }
           

        }
        
        return line;

    }
    
     public String getPasswordForRecovery(String username) throws IOException{ //return string
        BufferedReader bfrReader = new BufferedReader(new FileReader("Customer.txt"));
        String line = "";

        //line = bfrReader.readLine();
        while ((line = bfrReader.readLine()) != null) {
            values = line.split(",");

            if (values[0].equals(username)) {
                    break;
                   
            }
           

        }
        
        return line;

    }
    // search username used uring validation of registery details to check if username exists 
    public boolean searchUsername(String username)throws IOException{
        BufferedReader bfrReader = new BufferedReader(new FileReader("Customer.txt"));
        String line = "";
        while ((line = bfrReader.readLine()) != null) {
            values = line.split(",");
            if (values[0].equals(username)) {
                    return true;
            }          
        }     
        return false;
    }
       
        public void editValue(String filepath,String attributeEditing,String editTerm,String newName, String newPassword, String newEmail, String newAddress, double newFunds,String newContact) {
        try {
            String tempFile = "temp.txt";
            File oldFile = new File(filepath);
            File newFile = new File (tempFile);
            String name = "";  String password = ""; String email =""; String address = ""; String funds = ""; String contact ="";
            
            fileWriter = new FileWriter(tempFile, true);
            bufferWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferWriter);
            scanner = new Scanner(new File(filepath));
            scanner.useDelimiter(",");
            
            while(scanner.hasNext())
            {
                name = scanner.next();
                password = scanner.next();
                email = scanner.next();
                address = scanner.next();
                funds = scanner.next();
                contact = scanner.next();
                if (attributeEditing.equals(editTerm)) {
                    printWriter.println();
                }
            }
         scanner.close();
         printWriter.flush();
         printWriter.close();
         oldFile.delete();
         File dump = new File(filepath);
         newFile.renameTo(dump);
            
        } 
        catch (IOException ex) {
            Logger.getLogger(UserRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public ArrayList<String> getCustomerlist() {
        return customerlist;
    }

    public String[ ] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }
}