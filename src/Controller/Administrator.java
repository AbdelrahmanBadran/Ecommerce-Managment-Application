package Controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Administrator extends User{

    private String adminName, adminPass, email,contact;
    private int adminId;
    

    public Administrator(){

}
    public Administrator(String adminName, String adminPass){
    this.adminName = adminName;
    this.adminPass = adminPass;
}

     public Administrator(String adminName, String adminPass,int adminId,  String contact,String email ){

}
//<editor-fold defaultstate="collapsed" desc=" Getters and Setters for fields "> 
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
//</editor-fold>
    public Administrator copyOfObject(){
        Administrator copyObject = new Administrator(adminName, adminPass, adminId,  contact, email);
        return copyObject;
    }

    @Override
    public boolean verifyLogin(String username, String password)throws IOException{

        try {
            Administrator admin = model.readAdminFile();
            if (admin.getAdminName().equals(username) && admin.getAdminPass().equals(password)){
                JOptionPane.showMessageDialog(null, "Log in Successful");
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean validateUpdateDetails(String adminName,String adminPass,
            String newPass, String confirmPass, String email, String contact, String adminId ){
      
        if (adminName.equals("") || email.equals("") || contact.equals("") || adminId.equals("")) {
         JOptionPane.showMessageDialog(null,"One or more fields are left blank");
        return false;
        }
        
          if (! isInteger(adminId)) {
         JOptionPane.showMessageDialog(null,"Your ID must be a number");
        return false;
        }
          
        if (!adminName.matches("[a-zA-Z_]+")){
        JOptionPane.showMessageDialog(null, "Invalid name Entered");
        return false;
        }
        
        if(!contact.matches("[0-9*#+() -]*")){
             JOptionPane.showMessageDialog(null,"Incorrect phone number format");  
             return false;
        }
        
        if(!newPass.equals(confirmPass)){
            JOptionPane.showMessageDialog(null, "Please Confirm Password Correctly");
            return false;
        }
         
        return true;
    }
    
    public boolean isInteger( String input ) {
    try {
        Integer.parseInt( input );
        return true;
    }
    catch( NumberFormatException e ) {
        return false;
    }
}


}
