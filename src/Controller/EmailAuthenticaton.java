/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import javax.mail.Authenticator; 
import javax.mail.PasswordAuthentication; 
/**
 * 
 * @author AbdelRahman Badran , Madoma Diallo 
 */
public class EmailAuthenticaton extends Authenticator {
    @Override 
protected PasswordAuthentication getPasswordAuthentication() 
{ 
return new PasswordAuthentication("ooms.java@gmail.com", 
"wsad102938"); 
} 
    
}
