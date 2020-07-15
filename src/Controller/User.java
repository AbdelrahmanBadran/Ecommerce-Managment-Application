package Controller;

import Model.UserRepository;
import  View.Login;
import java.io.IOException;
import javax.swing.JOptionPane;


public class User  {
    private boolean signInStatus;
    protected UserRepository model = new UserRepository();
    private Customer currentCustomer;

   public boolean verifyLogin(String user, String password) throws IOException {
       String uservalues = model.searchCustomer(user, password);

       if(uservalues !=  null) {
            String[ ] userdetatils = model.getValues();
          this.currentCustomer = new Customer(userdetatils[0], userdetatils[1],userdetatils[2],userdetatils[3],Double.parseDouble(userdetatils[4]),userdetatils[5],Integer.parseInt(userdetatils[6]));
           JOptionPane.showMessageDialog(null, "Log in Successful! Welcome " + currentCustomer.getName().toUpperCase());
           currentCustomer.setSignInStatus(true);
           return true;
       }else {
       this.signInStatus = false;
       }
       return false;
      
//        model.readCustomerFile();
//        //model.getCustomerlist();
//
//        for (String line: model.getCustomerlist()){
//
//            if (line.contains(user + "," + password )){
//                return true;
//            }
//            else{
//
//            }
//        }
//        return false;
   };

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

        public boolean getSignInStatus() {
        return signInStatus;
    }
        
    public void setSignInStatus(boolean signInStatus) {
        this.signInStatus = signInStatus;
    }











  
//        model.readCustomerFile();
//        //model.getCustomerlist();
//
//        for (String line: model.getCustomerlist()){
//
//            if (line.contains(user + "," + password )){
//                return true;
//            }
//            else{
//
//            }
//        }
//        return false;
   


}
