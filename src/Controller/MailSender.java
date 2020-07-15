package Controller;


import java.net.SocketException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSender {
    private String emailHost = "smtp.gmail.com";
    private String emailPort ="587";
    private String fromEmail = "ooms.java@gmail.com";//user
    private String  toEmails[ ]= new String[1]  ;//to
    private String emailSubject; 
    private String emailBody;
   
    
    public void sendForgotPassword(String customerEmail, String customerName, String customerPassword) throws MessagingException, SocketException
    {
        Properties emailProperties;
        Session mailSession;
        MimeMessage emailMessage;
        toEmails[0] = customerEmail;
        emailBody = "Dear "+ customerName.toUpperCase()+",\n"+ "Your Password is:  "+ customerPassword;
        emailSubject="Password Recovery for online shopping application";
        
        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.host", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.host", emailHost);
        emailProperties.put("mail.smtp.auth", "true");
        
        EmailAuthenticaton authenticate = new EmailAuthenticaton();
        mailSession = Session.getInstance(emailProperties, authenticate);
        
        mailSession.getProperties().put("mail.smtp.ssl.trust", emailHost);
        //mailSession.setDebug(true);
        
        emailMessage = new MimeMessage(mailSession);
        emailMessage.setFrom(new InternetAddress(fromEmail));        
        emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerEmail, true));
        emailMessage.setSubject(emailSubject);
        emailMessage.setText(emailBody);
        emailMessage.setSentDate(new Date());
        
        
        Transport.send(emailMessage);
        
    }

    //might use later if needed
    public void sendOrderReply(){
    
    }

}


