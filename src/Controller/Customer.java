package Controller;

import Model.UserRepository;
import View.Register;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

public class Customer  extends User  {

    private String name, password,email,address,contact;
    private int  id;
    private double funds;
    private boolean signInStatus;
    private UserRepository dataRepository  = new UserRepository();

    public Customer(){

    }
     public Customer(String name, String password){
        this.name = name;
        this.password = password;
    }

    public Customer(String name, String password, String email, String address, double funds,String contact, int id) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.funds = funds;
        this.contact = contact;
        this.id = id;
    }
    
//<editor-fold defaultstate="collapsed" desc=" Getters and Setters for fields "> 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean getSignInStatus() {
        return signInStatus;
    }

    @Override
    public void setSignInStatus(boolean signInStatus) {
        this.signInStatus = signInStatus;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }
    
    //</editor-fold>

    public Customer copyOfCustomer() {
        Customer copyCustomerObject = new Customer( this.name,  this.password,  this.email, this.address, this.funds,this.contact, this.id);
        return copyCustomerObject;
    }
    public boolean validateRegisterDetails(String name, String email, String address, String password,String confirmPassword,String contact){
            if (!name.matches("[a-zA-Z_]+") || name.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid name Entered");
            return false;
            
        }
        try {
            if(dataRepository.searchUsername(name) || name.equals("Guest")){
                JOptionPane.showMessageDialog(null, "Username already Exists.Please use another name");
                return false;
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (email.equals("") || password.equals("") || confirmPassword.equals("") || contact.equals("")) {
             JOptionPane.showMessageDialog(null,"One or more fields have been left empty");
            return false;
        }
        if (!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(null,"Password does not Match!");
            return false;
        }
    
        if(!contact.matches("[0-9*#+() -]*")){
             JOptionPane.showMessageDialog(null,"The number is in correct format");  
             return false;
        }
        
        this.name = name;
        this.password= password;
        this.email = email;
        this.address = address;
        this.funds= 0;
        this.contact= contact;
        
        dataRepository.readCustomerFile();
        this.id = dataRepository.getNumberOfCustomers() + 1;
        return true;

    }
    
    public void  register() {
        try {
            dataRepository.writeToCustomerFile(this);
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void updateProfile(Customer oldCustomer, Customer updatedCustomer) throws IOException{
        String values = oldCustomer.getName()  + "," + oldCustomer.getPassword() + "," + oldCustomer.getEmail()  + "," + oldCustomer.getAddress() + "," + Double.toString(oldCustomer.getFunds() )+","+ oldCustomer.getContact() + "," + Integer.toString(oldCustomer.getId());
        String updatedValues = updatedCustomer.getName()  + "," + updatedCustomer.getPassword() + "," + updatedCustomer.getEmail()  + "," + updatedCustomer.getAddress() + "," + Double.toString(updatedCustomer.getFunds() )+ "," + updatedCustomer.getContact() + "," +Integer.toString(updatedCustomer.getId()) ;
        dataRepository.updateCustomerValues(values, updatedValues);
    }
    
    public boolean validateUpdateDetails(String name, String email, String address, String password,String confirmPassword,String contact){
            if (!name.matches("[a-zA-Z_]+") || name.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid name Entered");
            return false;
            
        }
            
        if (email.equals("") || contact.equals("")) {
             JOptionPane.showMessageDialog(null,"One or more fields have been left empty");
            return false;
        }
        if (!password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(null,"Password does not Match!");
            return false;
        }
    
        if(!contact.matches("[0-9*#+() -]*")){
             JOptionPane.showMessageDialog(null,"The number is in correct format");  
             return false;
        }
        
        return true;

    }
    
    public boolean passwordRecovery(String name, String email) throws IOException, MessagingException{
           String recoveryValues = dataRepository.getPasswordForRecovery(name) ;
        
         if (!name.matches("[a-zA-Z_]+") || name.equals("")){
            JOptionPane.showMessageDialog(null, "Invalid name Entered");
            return false;
            
        }
    
        if (email.equals("")) {
             JOptionPane.showMessageDialog(null,"One or more fields have been left empty");
            return false;
        }
        
        if (recoveryValues == null){
           JOptionPane.showMessageDialog(null, "Sorry! We couldn't find your Username"); 
           return false;
        }
        
                     
        String[ ] userdetatils = dataRepository.getValues();
         MailSender recoverPassword = new MailSender();
         recoverPassword.sendForgotPassword(email, name, userdetatils[1]);     

        return true;
    }
    
}
