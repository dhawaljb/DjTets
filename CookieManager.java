package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;

public class CookieManager {
	
	
	void getCurrentCookie(){
		
		 // create file named Cookies to store Login Information		
        File file = new File(System.getProperty("user.dir")+"\\Lib\\ResourceFiles\\Cookies.data");							
        try		
        {	  
            // Delete old file if exists
			file.delete();		
            file.createNewFile();			
            FileWriter fileWrite = new FileWriter(file);							
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
            // loop for getting the cookie information 		
            	
            // loop for getting the cookie information 		
            for(Cookie ck : utility.utils.driver.manage().getCookies())							
            {			
                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
                Bwrite.newLine();             
            }			
            Bwrite.close();			
            fileWrite.close();	
            
        }
        catch(Exception ex)					
        {		
            ex.printStackTrace();			
        }		
    
	}
	
	void setStoredCookie() {
		
		try{			
		     
	        File file = new File(System.getProperty("user.dir")+"\\Lib\\ResourceFiles\\Cookies.data");							
	        FileReader fileReader = new FileReader(file);							
	        BufferedReader Buffreader = new BufferedReader(fileReader);							
	        String strline;			
	        while((strline=Buffreader.readLine())!=null){									
	        StringTokenizer token = new StringTokenizer(strline,";");									
	        while(token.hasMoreTokens()){					
	        String name = token.nextToken();					
	        String value = token.nextToken();					
	        String domain = token.nextToken();					
	        String path = token.nextToken();					
	        Date expiry = null;					
	        		
	        String val;			
	        if(!(val=token.nextToken()).equals("null"))
			{		
	        	expiry = new Date(val);					
	        }		
	        Boolean isSecure = new Boolean(token.nextToken()).								
	        booleanValue();		
	        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
	        System.out.println(ck);
	        utility.utils.driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
	        }		
	        }		
	        }catch(Exception ex){					
	        ex.printStackTrace();			
	        }	
		
	}

}
