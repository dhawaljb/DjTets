
package utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.zeroturnaround.zip.ZipUtil;    
  
public class EmailReport{    
 public static void EmailReportTo() throws AddressException {   
	 
	//For Multifile zip folder
	 
	 
     
     //from,password,to,subject,message  
	 
	 InternetAddress[] ToList = InternetAddress.parse(Constant.EmailList);
	 DateFormat dateFormat = new SimpleDateFormat(" MM-dd-yyyy_HH.mm.ss");
		Date date = new Date();
		System.out.println("Sending report via email. Please wait...");
	 send("dhawal.bharkhada@slkgroup.com","ganesh_24287",ToList,"<SLK Selenium Automation Report>"+dateFormat.format(date),
			 "Hello,\r\n" + 
	 		"\r\n" + 
	 		"You are receiving this automated email to notify you that one of the automated test case has been failed and need your urgent attention.\r\n" + 
	 		"\r\n" + 
	 		"PFA detailed report.\r\n" + 
	 		"\r\n" + 
	 		"Sincerely,\r\n" + 
	 		"The SLK QA Team");
     //change from, password and to  
 }  
 
 public static void EmailReportOnSuccess() throws AddressException {    
	 
	
     //from,password,to,subject,message    
	 
	 InternetAddress[] ToList = InternetAddress.parse(Constant.EmailListForSuccess);
	 DateFormat dateFormat = new SimpleDateFormat(" MM-dd-yyyy_HH.mm.ss");
		Date date = new Date();
		System.out.println("Sending report via email. Please wait...");
	 send("dhawal.bharkhada@slkgroup.com","ganesh_24287",ToList,"<SLK Selenium Automation Report>"+dateFormat.format(date),
			 "Hello,\r\n" + 
				 		"\r\n" + 
				 		"You are receiving this automated email to notify you that automated test case has been executed successfully.\r\n" + 
				 		"\r\n" + 
				 		"PFA detailed report.\r\n" + 
				 		"\r\n" + 
				 		"Sincerely,\r\n" + 
				 		"The SLK QA Team");
     //change from, password and to  
 }
 
 public static void send(final String from,final String password,InternetAddress[] toList,String sub,String msg){  
     //Get properties object    
     Properties props = new Properties();    
     //props.put("mail.smtp.host", "smtp.gmail.com");    
     props.put("mail.smtp.host", "SLKMAILRELAY.SLKGROUP.COM");
     //props.put("mail.smtp.socketFactory.port", "465"); 
     props.put("mail.smtp.socketFactory.port", "25");
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
     props.put("mail.smtp.auth", "true");    
     //props.put("mail.smtp.port", "465");  
     props.put("mail.smtp.port", "25");  
     //get Session   
     Session session = Session.getDefaultInstance(props,    
      new javax.mail.Authenticator() {    
      protected PasswordAuthentication getPasswordAuthentication() {    
      return new PasswordAuthentication(from,password);  
      }    
     });    	
     
     //compose message    
     try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         // Set To: header field of the header.
         
         message.addRecipients(Message.RecipientType.TO, toList);

         // Set Subject: header field
         message.setSubject(sub);

         // Create the message part 
         BodyPart messageBodyPart = new MimeBodyPart();

         // Fill the message
         messageBodyPart.setText(msg);

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         
         
       //For Multifile zip folder
         File zipFile = new File(Constant.Path_EmailableReport);
         if(zipFile.exists()) {
        	 zipFile.delete();
         }
	     ZipUtil.pack(new File (Constant.Path_Report), new File(Constant.Path_EmailableReport));
//	     ZipUtil.pack(Constant.Path_Report, Constant.Path_EmailableReport, );
	     String filename = Constant.Path_EmailableReport;
         //For single file report
         //String filename = Constant.Path_Report;
         //String filename1 = Constant.Path_Report1;
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(new File(filename).getName());
         multipart.addBodyPart(messageBodyPart);
         
         /*DataSource source1 = new FileDataSource(filename1);
         messageBodyPart.setDataHandler(new DataHandler(source1));
         messageBodyPart.setFileName(new File(filename1).getName());
         multipart.addBodyPart(messageBodyPart);*/

         // Send the complete message parts
         message.setContent(multipart );

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
     
     }
     
     catch (MessagingException e) {
   	  
   	  throw new RuntimeException(e);
   	  
     }    
        
}

private static File File(String pathReport) {
	// TODO Auto-generated method stub
	return null;
}
 
 
}   